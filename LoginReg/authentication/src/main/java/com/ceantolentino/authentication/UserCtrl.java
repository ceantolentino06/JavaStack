package com.ceantolentino.authentication;

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

import com.ceantolentino.authentication.models.User;
import com.ceantolentino.authentication.services.UserService;
import com.ceantolentino.authentication.validator.UserValidator;

@Controller
public class UserCtrl {
	@Autowired
	UserService userService;
	
	@Autowired
	UserValidator userValidator;
	
	@GetMapping("/user/login")
	public String login() {
		return "loginPage.jsp";
	}
	
	@PostMapping("/user/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes errors) {
		if(userService.authenticateUser(email, password)) {
			User user = userService.findByEmail(email);
			session.setAttribute("user", user);
			return "redirect:/home";
		}else {
			errors.addFlashAttribute("loginFailed", "Login Failed");
			return "redirect:/user/login";
		}
	}
	
	@GetMapping("/user/register")
	public String register(@ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}
	
	@PostMapping("/user/register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "registrationPage.jsp";
		}else {
			User newUser = userService.registerUser(user);
			session.setAttribute("user", newUser);
			return "redirect:/home";
		}
	}
	
	@GetMapping("/home")
	public String home() {
		return "home.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/user/login";
	}
}
