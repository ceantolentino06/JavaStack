package com.ceantolentino.javaBeltExam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceantolentino.javaBeltExam.models.Rating;
import com.ceantolentino.javaBeltExam.models.Show;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
	List<Rating> findByShowOrderByRatingDesc(Show show);
}	
