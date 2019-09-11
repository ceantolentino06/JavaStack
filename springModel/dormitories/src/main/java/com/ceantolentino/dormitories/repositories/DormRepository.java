package com.ceantolentino.dormitories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ceantolentino.dormitories.models.Dorm;

public interface DormRepository extends CrudRepository<Dorm, Long>{
	
}
