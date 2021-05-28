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

import com.wh.model.ShipmentType;
import com.wh.service.IShipmentTypeService;

@Controller
@RequestMapping("/shipType")
public class ShipmentTypeController {

	@Autowired
	private IShipmentTypeService service;
	/*
	 * saves te entity or model obj
	 */
	@GetMapping("/add")
	public String addShipmentTypeform(@ModelAttribute ShipmentType om) {
		return "shipTypeForm";
	}//addShipmentTypeform
	@PostMapping("/add") 
	public String saveOrderMethdo(@ModelAttribute ShipmentType om, RedirectAttributes m) {
		Integer id=service.addShipType(om);
		m.addFlashAttribute("mgs"," ShipmentType with id "+id+ "is saved" );
	return "redirect:/shipType/show";
	}//saveOM
	
	@GetMapping("/show")
	public String showAll(Model m) {
		List<ShipmentType> ShipmentTypes=service.allShipmentType();
       m.addAttribute("ShipmentTypes",ShipmentTypes);
       return "showShipmentType";
	}//show

	@GetMapping("/delete")
	public String deleteShipmentType(@RequestParam Integer  shipTId,RedirectAttributes m) {
		service.deleteByShipmentTypeId(shipTId);
		m.addFlashAttribute("msg"," id "+ shipTId+" Is deleted");
		return "redirect:/shipType/show";
	}//delete
	/*
	 * for edit
	 */
	@GetMapping("/edit")
	public String editShipmentType(@RequestParam Integer shipTId, @ModelAttribute ShipmentType m) {
		ShipmentType om=service.getShipmentTypeModelById(shipTId);
		BeanUtils.copyProperties(om, m);
		return "shipTypeForm";
	}//delete
	@PostMapping("/edit")
	public String editSaveShipmentType(@ModelAttribute ShipmentType m, RedirectAttributes m1) {
		Integer id=service.addShipType(m);
		m1.addFlashAttribute("msg"," ShipmentType with ID: " +id+" is added");
		return "redirect:/shipType/show";
	}//delete
	
	
}
