package com.ceantolentino.dormitories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ceantolentino.dormitories.models.Student;
import com.ceantolentino.dormitories.services.DormStudentService;

@Controller
public class StudentCtrl {
	@Autowired
	DormStudentService dormStudentService;
	
	@GetMapping("/students/new")
	public String index(@ModelAttribute("newStudentObj") Student student) {
		return "/student/index.jsp";
	}
	
	@PostMapping("/students/new")
	public String create(@Valid @ModelAttribute("newStudentObj") Student student, BindingResult result) {
		if(result.hasErrors()) {
			return "/student/index.jsp";
		}else {
			dormStudentService.createStudent(student);
			return "redirect:/students/new";
		}
	}	
}
