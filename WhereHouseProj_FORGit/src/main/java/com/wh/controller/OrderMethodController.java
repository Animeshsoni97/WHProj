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
import com.wh.model.OrderMethod;
import com.wh.service.IOrderMethodService;

@Controller
@RequestMapping("/orderMethod")
public class OrderMethodController {
@Autowired
	private IOrderMethodService service;
	/*
	 * saves te entity or model obj
	 */
	@GetMapping("/add")
	public String addOrderMethodform(@ModelAttribute OrderMethod om) {
		return "OrderMethodForm";
	}//addOrderMethodform
	@PostMapping("/add")
	public String saveOrderMethdo(@ModelAttribute OrderMethod om, RedirectAttributes m) {
		Integer id=service.saveOrderMethod(om);
		m.addFlashAttribute("id1"," OrderMethod with id "+id+ "is saved" );
	return "redirect:/";
	}//saveOM
	
	@GetMapping("/show")
	public String showAll(Model m) {
		List<OrderMethod> orderMethods=service.allOrderMethod();
       m.addAttribute("orderMethods",orderMethods);
       return "showOrderMethod";
	}//show

	@GetMapping("/delete")
	public String deleteOrderMethod(@RequestParam Integer  orderMId,RedirectAttributes m) {
		service.deleteByOrderMethodId(orderMId);
		m.addFlashAttribute("id1"," id "+ orderMId+" Is deleted");
		return "redirect:/orderMethod/show";
	}//delete
	/*
	 * for edit
	 */
	@GetMapping("/edit")
	public String editOrderMethod(@RequestParam Integer orderMId, @ModelAttribute OrderMethod m) {
		OrderMethod om=service.getOrderMethodModelById(orderMId);
		BeanUtils.copyProperties(om, m);
		return "OrderMethodForm";
	}//delete
	@PostMapping("/edit")
	public String editSaveOrderMethod(@ModelAttribute OrderMethod m, RedirectAttributes m1) {
		Integer id=service.saveOrderMethod(m);
		m1.addFlashAttribute("id1"," OrderMethod with ID: " +id+" is added");
		return "redirect:/orderMethod/show";
	}//delete
}//class
