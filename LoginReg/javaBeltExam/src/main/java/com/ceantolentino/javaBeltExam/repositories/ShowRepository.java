package com.ceantolentino.javaBeltExam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceantolentino.javaBeltExam.models.Show;

@Repository
public interface ShowRepository extends CrudRepository<Show, Long>{
	List<Show> findAll();
	
	Show findByTitle(String title);
}
