package com.ceantolentino.javaBeltExam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ceantolentino.javaBeltExam.models.User;
import com.ceantolentino.javaBeltExam.services.UserService;
import com.ceantolentino.javaBeltExam.validator.UserValidator;

@Controller
public class UserCtrl {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping("/")
	public String index(@ModelAttribute("newUser") User user) {
		return "users/index.jsp";
	}
	
	@PostMapping("/")
	public String register(@Valid @ModelAttribute("newUser") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "users/index.jsp";
		}else {
			User newUser = userService.registerUser(user);
			session.setAttribute("user", newUser);
			return "redirect:/shows";
		}
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes errors) {
		if(userService.authenticateUser(email, password)) {
			User user = userService.findByEmail(email);
			session.setAttribute("user", user);
			return "redirect:/shows";
		}else {
			errors.addFlashAttribute("loginFailed", "Login Failed");
			return "redirect:/";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
	
}
