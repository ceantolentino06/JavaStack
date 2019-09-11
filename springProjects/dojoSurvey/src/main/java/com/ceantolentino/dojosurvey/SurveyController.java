package com.ceantolentino.dojosurvey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String submit(@RequestParam(value="name") String name, @RequestParam(value="location") String location,
	@RequestParam(value="lang") String lang,@RequestParam(value="comment") String comment, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("location", location);
		model.addAttribute("lang", lang);
		model.addAttribute("comment", comment);
		return "show.jsp";
	}
}
