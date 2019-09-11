package com.ceantolentino.beltReview.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.ceantolentino.beltReview.models.Comment;
import com.ceantolentino.beltReview.models.Event;
import com.ceantolentino.beltReview.models.User;
import com.ceantolentino.beltReview.services.UserService;

@Controller
public class EventCtrl {
	@Autowired
	private UserService userService;
	
	private SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");

	@GetMapping("/events")
	public String index(HttpSession session, @ModelAttribute("newEvent") Event event, Model model) {
		User user = (User) session.getAttribute("user");
		List<Event> eventsInMyState = userService.getAllEventByState(user.getState());
		for(Event e: eventsInMyState) {
			System.out.println(e.getJoined_users().contains(user));
		}
		List<Event> eventsInOtherStates = userService.getAllEventByOtherState(user.getState());
		model.addAttribute("eventsInOtherStates", eventsInOtherStates);
		model.addAttribute("formatter", formatter);
		model.addAttribute("eventsInMyState", eventsInMyState);
		return "event/index.jsp";
	}
	
	@PostMapping("/events")
	public String addEvent(@Valid @ModelAttribute("newEvent") Event event, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "event/index.jsp";
		}else {
			userService.createEvent(event);
			return "redirect:/events";
		}
	}
	
	@GetMapping("/events/{id}")
	public String showEvent(@PathVariable("id") Long id, Model model, HttpSession session) {
		Event event = userService.getEvent(id);
		model.addAttribute("event", event);
		model.addAttribute("formatter", formatter);
		Comment comment = new Comment();
		model.addAttribute("newComment", comment);
		return "event/show.jsp";
	}
	
	@PostMapping("/events/{id}")
	public String addComment(@PathVariable("id") Long id, @Valid @ModelAttribute("newComment") Comment comment, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/events/"+id;
		} else {
			userService.addEventComment(comment);
			return "redirect:/events/"+id;
		}
	}
	
	@GetMapping("/events/{id}/edit")
	public String editEvent(@PathVariable("id") Long id, Model model) {
		Event thisEvent = userService.getEvent(id);
		model.addAttribute("event", thisEvent);
		model.addAttribute("eventName", thisEvent.getName());
		return "event/edit.jsp";
	}
	
	@PostMapping("/events/{id}/edit")
	public String edit(@PathVariable("id") Long id, @Valid @ModelAttribute("event") Event event, BindingResult result, Model model) {
		if(result.hasErrors()) {
			Event thisEvent = userService.getEvent(id);
			model.addAttribute("eventName", thisEvent.getName());
			return "event/edit.jsp";
		} else {
			userService.createEvent(event);
			return "redirect:/events/"+id+"/edit";
		}
	}
	
	@RequestMapping("/join/{event_id}")
	public String joinEvent(@PathVariable("event_id") Long id, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Event event = userService.getEvent(id);
		ArrayList<Event> eventList = (ArrayList<Event>) user.getJoined_events();
		eventList.add(event);
		user.setJoined_events(eventList);
		userService.registerUser(user);
		return "redirect:/events";
	}
 	
}
