package com.ceantolentino.dormitories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ceantolentino.dormitories.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	List<Student> findAll();

	List<Student> findByDormIsNull();
	
}
