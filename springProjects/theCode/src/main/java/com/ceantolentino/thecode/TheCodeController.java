package com.ceantolentino.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TheCodeController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String submit(@RequestParam(value="code") String code, RedirectAttributes error) {
		if(code.equals("bushido")) {
			return "redirect:/main";
		}else {
			error.addFlashAttribute("error", "You must train harder!");
			return "redirect:/";
		}
	}
	
	@RequestMapping("/main")
	public String main() {
		return "main.jsp";
	}
}
