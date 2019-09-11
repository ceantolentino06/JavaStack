package com.ceantolentino.beltReview.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ceantolentino.beltReview.models.Event;

public interface EventRepository extends CrudRepository<Event, Long>{
	List<Event> findByStateEquals(String state);
	
	List<Event> findByStateNot(String state);
	
}
