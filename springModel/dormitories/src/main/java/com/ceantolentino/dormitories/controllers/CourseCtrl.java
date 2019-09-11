package com.ceantolentino.dormitories.controllers;

import java.util.List;

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

import com.ceantolentino.dormitories.models.Course;
import com.ceantolentino.dormitories.models.Student;
import com.ceantolentino.dormitories.models.StudentCourse;
import com.ceantolentino.dormitories.services.DormStudentService;

@Controller
public class CourseCtrl {
	@Autowired
	DormStudentService studentService;
	
	@GetMapping("/classes/create")
	public String index(@ModelAttribute("newCourseObj") Course course) {
		return "course/index.jsp";
	}
	
	@PostMapping("/classes/create")
	public String create(@Valid @ModelAttribute("newCourseObj") Course course, BindingResult result) {
		if(result.hasErrors()) {
			return "course/index.jsp";
		}else {
			studentService.createCourse(course);
			return "redirect:/classes/create";
		}
	}
	
	@GetMapping("/students/{id}")
	public String addCourseStudent(Model model, @PathVariable("id") Long id, @ModelAttribute("newRelObj") StudentCourse sc) {
		Student s = studentService.findStudent(id);
		List<Course> allCourses = studentService.getAllCourses(s.getCourses());
		List<StudentCourse> studentCourses = studentService.getAllStudentCourse(s);
		model.addAttribute("student", s);
		model.addAttribute("courses", allCourses);
		model.addAttribute("studentCourses", studentCourses);
		return "course/addClass.jsp";
	}
	
	@PostMapping("/students/{id}/add")
	public String addCourseStudentPost(@Valid @ModelAttribute("newRelObj") StudentCourse sc, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "course/addClass.jsp";
		}else {
			studentService.addCourse(sc);
			return "redirect:/students/"+id;
		}
	}
	
	@RequestMapping("/drop/{studentId}/{id}")
	public String dropCourse(@PathVariable("id") Long id, @PathVariable("studentId") Long studentId) {
		studentService.deleteCourse(id);
		return "redirect:/students/"+studentId;
	}
	
	@GetMapping("/classes/{id}")
	public String showCourse(@PathVariable("id") Long id, Model model) {
		Course thisCourse = studentService.findCourse(id);
		model.addAttribute("course", thisCourse);
		return "course/showCourse.jsp";
	}
}
