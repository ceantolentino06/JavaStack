package com.ceantolentino.dormitories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceantolentino.dormitories.models.Course;
import com.ceantolentino.dormitories.models.Dorm;
import com.ceantolentino.dormitories.models.Student;
import com.ceantolentino.dormitories.models.StudentCourse;
import com.ceantolentino.dormitories.repositories.CourseRepository;
import com.ceantolentino.dormitories.repositories.DormRepository;
import com.ceantolentino.dormitories.repositories.StudentCourseRepository;
import com.ceantolentino.dormitories.repositories.StudentRepository;

@Service
public class DormStudentService {
	@Autowired
	DormRepository dormRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentCourseRepository scRepository;
	
	public Dorm createDorm(Dorm d) {
		return dormRepository.save(d);
	}
	
	public Student createStudent(Student s) {
		return studentRepository.save(s);
	}
	
	public Course createCourse(Course c) {
		return courseRepository.save(c);
	}
	
	public Dorm findDorm(Long id) {
		Optional<Dorm> optDorm = dormRepository.findById(id);
		if(optDorm.isPresent()) {
			return optDorm.get();
		}else {
			return null;
		}
	}
	
	public Course findCourse(Long id) {
		Optional<Course> optCourse = courseRepository.findById(id);
		if(optCourse.isPresent()) {
			return optCourse.get();
		}else {
			return null;
		}
	}
	
	public StudentCourse addCourse(StudentCourse sc) {
		return scRepository.save(sc);
	}
	
	public Student findStudent(Long id) {
		Optional<Student> optStudent = studentRepository.findById(id);
		if(optStudent.isPresent()) {
			return optStudent.get();
		}else {
			return null;
		}
	}
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public List<Student> getAllStudentWODorm(){
		return studentRepository.findByDormIsNull();
	}

	public List<Course> getAllCourses(List<Course> courses) {
		return courseRepository.findAll();
	}
	
	public List<StudentCourse> getAllStudentCourse(Student student) {
		return scRepository.findByStudent(student);
	}

	public void deleteCourse(Long id) {
		scRepository.deleteById(id);
		
	}

}
