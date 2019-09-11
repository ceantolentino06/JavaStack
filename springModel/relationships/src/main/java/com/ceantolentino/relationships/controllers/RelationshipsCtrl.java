package com.ceantolentino.relationships.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ceantolentino.relationships.models.License;
import com.ceantolentino.relationships.models.Person;
import com.ceantolentino.relationships.services.RelationshipService;

@Controller
public class RelationshipsCtrl {
	private final RelationshipService relService;
	
	public RelationshipsCtrl(RelationshipService relService) {
		this.relService = relService;
	}
	
	@GetMapping("/person/new")
	public String index(@ModelAttribute("person") Person person) {
		return "index.jsp";
	}
	
	@PostMapping("/person/new")
	public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			relService.createPerson(person);
			return "redirect:/person/new";
		}
	}
	
	@GetMapping("/licenses/new")
	public String license(@ModelAttribute("license") License license, Model model) {
		List<Person> allPersons = relService.allPersons();
		model.addAttribute("persons", allPersons);
		return "license.jsp";
	}
	
	@PostMapping("/licenses/new")
	public String create_license(@ModelAttribute("license") License license, @RequestParam("person") String person,
			@RequestParam("state") String state, @RequestParam("date") String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date expDate = format.parse(date);
		license.setExpirationDate(expDate);
		license.setPerson(relService.getPerson(Long.parseLong(person)));
		license.setState(state);
		relService.createLicense(license);
		return "redirect:/licenses/new";
	}
}
