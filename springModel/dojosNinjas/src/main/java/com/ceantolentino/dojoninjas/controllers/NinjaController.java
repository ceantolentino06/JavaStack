package com.ceantolentino.dojoninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ceantolentino.dojoninjas.models.Ninja;
import com.ceantolentino.dojoninjas.services.DojoNinjaService;

@Controller
public class NinjaController {
	@Autowired
	DojoNinjaService dojoNinjaService;
	
	@GetMapping("/ninja/new")
	public String index(@ModelAttribute("newNinjaObj") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoNinjaService.getAllDojos());
		return "ninja.jsp";
	}
	
	@PostMapping("/ninja/new")
	public String create(@Valid @ModelAttribute("newNinjaObj") Ninja ninja, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "ninja.jsp";
		}else {
			dojoNinjaService.createNinja(ninja);
			return "redirect:/ninja/new";
		}
	}
}
