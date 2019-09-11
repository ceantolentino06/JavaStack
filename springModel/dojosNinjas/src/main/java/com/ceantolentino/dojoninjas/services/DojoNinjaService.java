package com.ceantolentino.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceantolentino.dojoninjas.models.Dojo;
import com.ceantolentino.dojoninjas.models.Ninja;
import com.ceantolentino.dojoninjas.repositories.DojoRepository;
import com.ceantolentino.dojoninjas.repositories.NinjaRepository;

@Service
public class DojoNinjaService {
	@Autowired
	DojoRepository dojoRepo;
	
	@Autowired
	NinjaRepository ninjaRepo;
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}

	public List<Dojo> getAllDojos() {
		return dojoRepo.findAll();
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optDojo = dojoRepo.findById(id);
		if(optDojo.isPresent()) {
			return optDojo.get();
		}else {
			return null;
		}
	}
}
