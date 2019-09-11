package com.ceantolentino.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

import com.ceantolentino.languages.models.Language;
import com.ceantolentino.languages.repositories.LanguageRepository;

@Controller
public class LanguageService {
	private final LanguageRepository languageRepo;
	
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	
	public List<Language> allLanguages(){
		return languageRepo.findAll();
	}
	
	public Language createLanguage(Language b) {
		return languageRepo.save(b);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> optionalLang = languageRepo.findById(id);
		if(optionalLang.isPresent()) {
			return optionalLang.get();
		}else {
			return null;
		}
	}
	
	public Language updateLanguage(Language language) {
		return languageRepo.save(language);
	}
	
	public void deleteLanguage(Long id) {
    	languageRepo.deleteById(id);
    }
	
	
}
