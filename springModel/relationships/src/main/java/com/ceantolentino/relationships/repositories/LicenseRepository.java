package com.ceantolentino.relationships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceantolentino.relationships.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
	
}
