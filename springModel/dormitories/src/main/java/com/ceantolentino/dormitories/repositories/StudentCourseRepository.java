package com.ceantolentino.dormitories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceantolentino.dormitories.models.Student;
import com.ceantolentino.dormitories.models.StudentCourse;

@Repository
public interface StudentCourseRepository extends CrudRepository<StudentCourse, Long>{
	List<StudentCourse> findByStudent(Student student);
}
