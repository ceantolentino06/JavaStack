package com.ceantolentino.ninjagold;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Gold")
public class NinjaGoldController {
	
	@RequestMapping("")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("gold")==null) {
			session.setAttribute("gold", 0);
		}
		if(session.getAttribute("action")==null) {
			ArrayList<String> action = new ArrayList<String>();
			session.setAttribute("action", action);
		}
		System.out.println(session.getAttribute("action"));
		model.addAttribute("actions", session.getAttribute("action"));
		return "index.jsp";
	}
	
	@RequestMapping("/get_gold")
	public String get_gold(HttpSession session, @RequestParam("location") String location) {
		Random rand = new Random();
		Date date = new Date();
		int gold = (int) session.getAttribute("gold");
		ArrayList action = (ArrayList) session.getAttribute("action");
		if(location.equals("farm")) {
			Integer random = rand.nextInt(20-10+1)+10;
			gold += random;
			action.add("Earned "+random.toString()+" golds from the "+location+"! ("+date+")");
			session.setAttribute("action", action);
			session.setAttribute("gold", gold);
		}
		else if(location.equals("cave")) {
			Integer random = rand.nextInt(10-5+1)+5;
			gold += random;
			action.add("Earned "+random.toString()+" golds from the "+location+"! ("+date+")");
			session.setAttribute("action", action);
			session.setAttribute("gold", gold);
		}
		else if(location.equals("house")) {
			Integer random = rand.nextInt(5-2+1)+2;
			gold += random;
			action.add("Earned "+random.toString()+" golds from the "+location+"! ("+date+")");
			session.setAttribute("action", action);
			session.setAttribute("gold", gold);
		}
		else if(location.equals("casino")) {
			Integer random = rand.nextInt(50-(-50)+1)+(-50);
			gold += random;
			if(random>0) {
				action.add("Entered a "+location+" and earned "+random.toString()+" golds! ("+date+")");
			}
			else {
				action.add("Entered a "+location+" and lost "+random.toString()+" golds...Ouch ("+date+")");
			}
			
			session.setAttribute("action", action);
			session.setAttribute("gold", gold);
		}
		return "redirect:";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.removeAttribute("gold");
		session.removeAttribute("action");
		return "redirect:";
	}
}
