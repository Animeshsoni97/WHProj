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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.wh.model.WhUserType;
import com.wh.service.IWHUserService;

@Controller
@RequestMapping("/whUser")
public class WHUserTypeController {
@Autowired
	private IWHUserService service;
	/*
	 * saves te entity or model obj
	 */
	@GetMapping("/add")
	public String addWHUserTypeform(@ModelAttribute WhUserType om) {
		return "whUserTypeForm";
	}//addWHUserTypeform
	@PostMapping("/add")
	public String saveOrderMethdo(@ModelAttribute WhUserType om, RedirectAttributes m) {
		Integer id=service.saveWHUserType(om);
		m.addFlashAttribute("msg"," WHUserType with id "+id+ "is saved" );
	return "redirect:/whUser/show";
	}//saveOM
	
	@GetMapping("/show")
	public String showAll(Model m) {
		List<WhUserType> WhUserTypes=service.allWHUserType();
       m.addAttribute("wh_users",WhUserTypes);
       return "showWHUserType";
	}//show

	@GetMapping("/delete")
	public String deleteWHUserType(@RequestParam Integer  whUserId,RedirectAttributes m) {
		service.deleteByWHUserTypeId(whUserId);
		m.addFlashAttribute("msg"," id "+ whUserId+" Is deleted");
		return "redirect:/whUser/show";
	}//delete
	/*
	 * for edit
	 */
	@GetMapping("/edit")
	public String editWHUserType(@RequestParam Integer whUserId, @ModelAttribute WhUserType m) {
		WhUserType om=service.getWHUserTypeById(whUserId);
		BeanUtils.copyProperties(om, m);
		return "whUserTypeForm";
	}//delete
	@PostMapping("/edit")
	public String editSaveWHUserType(@ModelAttribute WhUserType m, RedirectAttributes m1) {
		Integer id=service.saveWHUserType(m);
		m1.addFlashAttribute("msg"," WHUserType with ID: " +id+" is added");
		return "redirect:/whUser/show";
	}//delete
	
	@GetMapping("/validate")
	public @ResponseBody String validateDuplicateMode(@RequestParam String modal) {
		boolean res=service.isCodeDuplicate(modal);
		if(res==true)
			return "whUser Code is Already taken";
		else return "";
	}//
}//class
