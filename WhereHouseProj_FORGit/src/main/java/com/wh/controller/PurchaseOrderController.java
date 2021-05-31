package com.wh.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wh.model.PurchaseDetail;
import com.wh.model.PurchaseOrder;
import com.wh.service.IPartService;
import com.wh.service.IPurchaseDetailService;
import com.wh.service.IPurchaseOrderService;
import com.wh.service.IShipmentTypeService;
import com.wh.service.IWHUserService;

@Controller
@RequestMapping("/po")
public class PurchaseOrderController {
	@Autowired
	private IPurchaseOrderService service;
	@Autowired
	private IWHUserService whUserService;
	@Autowired
	private IShipmentTypeService shipService;
	@Autowired
	private IPartService partService;	
	@Autowired
	private IPurchaseDetailService purDetailService;
	

	public void addwhUserCode(Model m) {
		m.addAttribute("whUserCode",whUserService.getwhUserIdAndCodeByType("vendor"));
	}
	public void addshipCode(Model m) {
		m.addAttribute("shipEnable", shipService.getShipIdAndCodeForEnable());
	}
	public void addpartsIdAndCode(Model m) {
		m.addAttribute("parts", partService.getAllPartsAsMapIdAndCode());
	}

	/*
	 * saves te entity or model obj
	 */
	@GetMapping("/add")
	public String addPurchaseOrderform( Model m) {
		PurchaseOrder po=new PurchaseOrder();
		po.setPoStatus("OPEN");
		m.addAttribute("purchaseOrder",po );
		addwhUserCode(m);
		addshipCode(m);
		return "PurchaseOrderForm";
	}//addPurchaseOrderform
	@PostMapping("/add")
	public String saveOrderMethdo(@ModelAttribute PurchaseOrder om, RedirectAttributes m) {
		Integer id=service.savePurchaseOrder(om);
		m.addFlashAttribute("msg"," PurchaseOrder with id "+id+ "is saved" );
		return "redirect:/po/show";
	}//saveOM

	@GetMapping("/show")
	public String showAll(Model m) {
		List<PurchaseOrder> PurchaseOrders=service.allPurchaseOrder();
		m.addAttribute("PurchaseOrders",PurchaseOrders);
		return "showPurchaseOrder";
	}//show

	@GetMapping("/delete")
	public String deletePurchaseOrder(@RequestParam Integer  orderMId,RedirectAttributes m) {
		service.deleteByPurchaseOrderId(orderMId);
		m.addFlashAttribute("msg"," id "+ orderMId+" Is deleted");
		return "redirect:/po/show";
	}//delete
	/*
	 * for edit
	 */
	@GetMapping("/edit")
	public String editPurchaseOrder(@RequestParam Integer orderMId,Model m) {
		PurchaseOrder po=new PurchaseOrder();
		po.setPoStatus("OPEN");
		m.addAttribute("purchaseOrder",po );
		addwhUserCode(m);
		addshipCode(m);
		PurchaseOrder om=service.getPurchaseOrderModelById(orderMId);
		BeanUtils.copyProperties(om, m);
		return "PurchaseOrderForm";
	}//delete
	@PostMapping("/edit")
	public String editSavePurchaseOrder(@ModelAttribute PurchaseOrder m, RedirectAttributes m1) {
		Integer id=service.savePurchaseOrder(m);
		m1.addFlashAttribute("msg"," PurchaseOrder with ID: " +id+" is added");
		return "redirect:/po/show";
	}//delete

	@GetMapping("/addPart")
	public String addParts(@RequestParam Integer poId,Model m) {
		m.addAttribute("showPartsDetails", purDetailService.getAllPurchaseDetails(poId));
		m.addAttribute("po",service.getPurchaseOrderModelById(poId));
		m.addAttribute("msg",poId);
	     addpartsIdAndCode(m); 
	      m.addAttribute("purchaseDetail",new PurchaseDetail());
		return "PurchaseOrderParts";
	}
	@PostMapping("/addPart")
    public String showPartsAgain(@RequestParam Integer poId,@ModelAttribute PurchaseDetail pd) {
		PurchaseOrder poo=new PurchaseOrder();
		poo.setPoId(poId);
		pd.setPurchaseOrder(poo); 
		Integer pOId=purDetailService.savePurchaseDetail(pd);
	   return "redirect:/po/addPart?poId="+pOId;
	}//
}//class
