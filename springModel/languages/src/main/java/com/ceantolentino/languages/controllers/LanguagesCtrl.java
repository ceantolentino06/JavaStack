package com.ceantolentino.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ceantolentino.languages.models.Language;
import com.ceantolentino.languages.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguagesCtrl {
	private final LanguageService languageService;
	
	public LanguagesCtrl(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("")
	public String index(Model model, @ModelAttribute("language") Language language) {
		List<Language> allLang = languageService.allLanguages();
		model.addAttribute("languages", allLang);
		return "index.jsp";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Language> allLang = languageService.allLanguages();
			model.addAttribute("languages", allLang);
			return "/index.jsp";
		}else {
			languageService.createLanguage(language);
			return "redirect:";
		}
	}
	
	@RequestMapping("/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language lang = languageService.findLanguage(id);
		model.addAttribute("language", lang);
		return "edit.jsp";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			languageService.updateLanguage(language);
			return "redirect:";
		}
	}
	
	@RequestMapping("/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Language lang = languageService.findLanguage(id);
		model.addAttribute("language", lang);
		return "show.jsp";
	}
	
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:";
    }
}
