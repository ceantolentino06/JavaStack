package com.ceantolentino.beltReview.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ceantolentino.beltReview.models.User;
import com.ceantolentino.beltReview.services.UserService;
import com.ceantolentino.beltReview.validator.UserValidator;

@Controller
public class UserCtrl {
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping("/")
	public String index(@ModelAttribute("newUser") User user){
		return "user/index.jsp";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes errors) {
		if(userService.authenticateUser(email, password)) {
			User user = userService.findByEmail(email);
			session.setAttribute("user", user);
			return "redirect:/events";
		}else {
			errors.addFlashAttribute("loginFailed", "Login Failed");
			return "redirect:/";
		}
	}
	
	@PostMapping("/")
	public String register(@RequestParam("email") String email, @Valid @ModelAttribute("newUser") User user, BindingResult result,
			RedirectAttributes errors, HttpSession session) {
		User isAvailable = userService.findByEmail(email);
		if(isAvailable!=null) {
			errors.addFlashAttribute("emailReg", "This email is already registed");
			return "redirect:/";
		}else {
			userValidator.validate(user, result);
			if(result.hasErrors()) {
				return "user/index.jsp";
			}else {
				User newUser = userService.registerUser(user);
				session.setAttribute("user", newUser);
				return "redirect:/events";
			}
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
}
