package com.wh.controller;

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

import com.wh.model.Uom;
import com.wh.service.IUomService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
/*
 * controller for uom module
 */
@Controller
@RequestMapping("/uom")
public class UomController {
	@Autowired
	private IUomService service;
	/*
	 * this is for adding UOM
	 */
	@GetMapping("/addUom")
	public String addUOM(@ModelAttribute Uom umodel) {
		return "UomForm";
	}//welcome()

	@PostMapping("/addUom")
	public String SaveUomModel(@ModelAttribute Uom umodel,RedirectAttributes m) {
		Integer id=service.saveUom(umodel);
		m.addFlashAttribute("id1"," UOM with ID: " +id+" is added");
		return "redirect:/uom/showUom";
	}
	@GetMapping("/showUom")
	public String showUOM(Model m) {
		m.addAttribute("uoms", service.allUom());
		return "showUom";
	}//showUOM

	/*
	 * to delete operation
	 */
	@GetMapping("/delete")
	public String deleteUom(@RequestParam Integer uomId ,RedirectAttributes m) {
		service.deleteByUomId(uomId);
		m.addFlashAttribute("id1","<h4>id "+ uomId+" Is deleted<h4>");
		return "redirect:/uom/showUom";
	}//delete
	/*
	 * for edit
	 */
	@GetMapping("/edit")
	public String editUom(@RequestParam Integer uomId, @ModelAttribute Uom m) {
		Uom uom=service.getUomModelById(uomId);
		BeanUtils.copyProperties(uom, m);
		return "UomForm";
	}//delete
	@PostMapping("/edit")
	public String editSaveUom(@ModelAttribute Uom m, RedirectAttributes m1) {
		Integer id=service.saveUom(m);
		m1.addFlashAttribute("id1"," UOM with ID: " +id+" is added");
		return "redirect:/uom/showUom";
	}//delete
}//class
