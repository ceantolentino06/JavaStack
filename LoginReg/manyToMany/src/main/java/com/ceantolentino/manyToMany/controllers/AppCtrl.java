package com.ceantolentino.manyToMany.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ceantolentino.manyToMany.models.Event;
import com.ceantolentino.manyToMany.models.User;
import com.ceantolentino.manyToMany.services.AppService;

@Controller
public class AppCtrl {
	@Autowired
	private AppService appService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("newUser") User user) {
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User user,
			BindingResult result,
			HttpSession session) {
		if(result.hasErrors()) {
			return "index.jsp";
		}else {
			User newUser = appService.registerUser(user);
			session.setAttribute("user", newUser);
			return "redirect:/home";
		}
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("username") String uname,
			@RequestParam("password") String pword,
			HttpSession session){
		if(appService.authenticateUser(uname, pword)) {
			User user = appService.findByUsername(uname);
			session.setAttribute("user", user);
			return "redirect:/home";
		}else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/home")
	public String home(@ModelAttribute("newEvent") Event event, Model model) {
		model.addAttribute("all_events", appService.getAllEvents());
		return "home.jsp";
	}
	
	@PostMapping("/addEvent")
	public String createEvent(@ModelAttribute("newEvent") Event event) {
		appService.createNewEvent(event);
		return "redirect:/home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
	
	@RequestMapping("/join/{id}")
	public String joinEvent(@PathVariable("id") Long id, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Event event = appService.getEventById(id);
		List<Event> myEvents = user.getJoined_events();
		myEvents.add(event);
		user.setJoined_events(myEvents);
		appService.updateUser(user);
		return "redirect:/home";
	}
}
