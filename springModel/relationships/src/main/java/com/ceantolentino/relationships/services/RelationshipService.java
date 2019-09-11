package com.ceantolentino.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ceantolentino.relationships.models.License;
import com.ceantolentino.relationships.models.Person;
import com.ceantolentino.relationships.repositories.LicenseRepository;
import com.ceantolentino.relationships.repositories.PersonRepository;

@Service
public class RelationshipService {
	private final PersonRepository personRepo;
	private final LicenseRepository licenseRepo;
	
	
	public RelationshipService(PersonRepository personRepo, LicenseRepository licenseRepo) {
		this.personRepo = personRepo;
		this.licenseRepo = licenseRepo;
	}
	
	public Person createPerson(Person p) {
		return personRepo.save(p);
	}
	
	public List<Person> allPersons(){
		return personRepo.findAll();
	}
	
	public License createLicense(License l) {
		return licenseRepo.save(l);
	}
	
	public Person getPerson(Long id) {
		Optional<Person> thisPerson = personRepo.findById(id);
		if(thisPerson.isPresent()) {
			return thisPerson.get();
		} else {
			return null;
		}
		
	}
}
