package com.wh.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wh.model.Part;
import com.wh.service.IOrderMethodService;
import com.wh.service.IPartService;
import com.wh.service.IUomService;

@Controller
@RequestMapping("/part")
public class PartController {

@Autowired
private IPartService service;
@Autowired
private IUomService uomService;
@Autowired
private IOrderMethodService omService;

private void addUomModelData(Model m) {
   m.addAttribute("uoms",uomService.getUomIdAndModelAsMap());
}//
private void addOMCodeDataForSale(Model m) {
	m.addAttribute("omsSale",omService.getIdAndCodeByPassingMode("sale"));
}//
private void addOMCodeDataForPurchase(Model m) {
	m.addAttribute("omsPurchase",omService.getIdAndCodeByPassingMode("purchase"));
}//

//1. show Parts Register Page
@GetMapping("/add")
public String showReg(Model model ) {
model.addAttribute("part", new Part());
addUomModelData(model);
addOMCodeDataForSale(model);
addOMCodeDataForPurchase(model);
return "PartRegister";
}
//2. save Parts
@PostMapping("/add")
public String savePart(@ModelAttribute Part part, RedirectAttributes model) {
Integer id = service.savePart(part);
model.addFlashAttribute("msg", "Part '"+id+"' Added");
model.addAttribute("part", new Part());
return "redirect:/part/show";
}

@GetMapping("/show")
public String showAll(Model m) {
	List<Part> Parts=service.getAllParts();
   m.addAttribute("parts",Parts);
   return "showPart";
}//show

@GetMapping("/delete")
public String deletePart(@RequestParam Integer  partId,RedirectAttributes m) {
	service.deletePart(partId);
	m.addFlashAttribute("msg"," id "+ partId+" Is deleted");
	return "redirect:/part/show";
}//delete
/*
 * for edit
 */
@GetMapping("/edit")
public String editPart(@RequestParam Integer partId, Model model) {
	Part part=service.getOnePart(partId);//try @ModelAttribute
	model.addAttribute("part",part);
	addUomModelData(model);
	addOMCodeDataForSale(model);
	addOMCodeDataForPurchase(model);
	return "PartRegister";
}//delete
@PostMapping("/edit")
public String editSavePart(@ModelAttribute Part m, RedirectAttributes m1) {
	System.out.println("part: "+m);
	Integer id=service.savePart(m);
	m1.addFlashAttribute("msg"," Part with ID: " +id+" is Updated");
	return "redirect:/part/show";
}//delete
@GetMapping("/validatePart")
public @ResponseBody String checkDuplicatePart(@RequestParam String part) {

	boolean res=service.getIfPartDuplicate(part);
if(res) {
	return "ALREADY TAKEN PLEASE CHOOSE OTHER";
}
else return "";
}
}

