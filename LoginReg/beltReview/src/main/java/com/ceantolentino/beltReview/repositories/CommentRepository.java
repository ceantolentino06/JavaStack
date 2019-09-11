package com.ceantolentino.beltReview.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ceantolentino.beltReview.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>{
	
}
