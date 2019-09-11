package com.ceantolentino.dojoninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ceantolentino.dojoninjas.models.Dojo;
import com.ceantolentino.dojoninjas.services.DojoNinjaService;

@Controller
public class DojoController {
	@Autowired
	DojoNinjaService dojoNinjaService;
	
	@GetMapping("/dojo/new")
	public String index(@ModelAttribute("newDojoObj") Dojo dojo) {
		return "index.jsp";
	}
	
	@PostMapping("/dojo/new")
	public String create(@ModelAttribute("newDojoObj") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}else {
			dojoNinjaService.createDojo(dojo);
			return "redirect:/dojo/new";
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String show(@PathVariable("id") String id, Model model) {
		Dojo dojo = dojoNinjaService.findDojo(Long.parseLong(id));
		model.addAttribute("dojo", dojo);
		System.out.println(dojo.getNinjas());
		return "show.jsp";
	}
	
}
