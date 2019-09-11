package com.ceantolentino.dormitories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ceantolentino.dormitories.models.Dorm;
import com.ceantolentino.dormitories.models.Student;
import com.ceantolentino.dormitories.services.DormStudentService;

@Controller
public class DormCtrl {
	@Autowired
	DormStudentService dormStudentService;
	
	@GetMapping("/dorms/new")
	public String index(@ModelAttribute("newDormObj") Dorm dorm) {
		return "/dorm/index.jsp";
	}
	
	@PostMapping("/dorms/new")
	public String create(@Valid @ModelAttribute("newDormObj") Dorm dorm, BindingResult result) {
		if(result.hasErrors()) {
			return "/dorm/index.jsp";
		} else {
			dormStudentService.createDorm(dorm);
			return "redirect:/dorms/new";
		}
	}
	
	@GetMapping("/dorms/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Dorm thisDorm = dormStudentService.findDorm(id);
		model.addAttribute("dorm", thisDorm);
		model.addAttribute("students", dormStudentService.getAllStudentWODorm());
		return "/dorm/show.jsp";
	}
	
	@PostMapping("/dorms/{dormID}")
	public String addStudent(@PathVariable("dormID") Long dormID, @RequestParam("student") Long studentID) {
		Dorm thisDorm = dormStudentService.findDorm(dormID);
		Student thisStudent = dormStudentService.findStudent(studentID);
		thisStudent.setDorm(thisDorm);
		dormStudentService.createStudent(thisStudent);
		return "redirect:/dorms/"+dormID;
	}
	
	
	@GetMapping("/dorms/{dormID}/remove/{studentID}")
	public String removeStudent(@PathVariable("dormID") Long dormID, @PathVariable("studentID") Long studentID) {
		Student thisStudent = dormStudentService.findStudent(studentID);
		thisStudent.setDorm(null);
		dormStudentService.createStudent(thisStudent);
		return "redirect:/dorms/"+dormID;
	}
	
	
	
}
