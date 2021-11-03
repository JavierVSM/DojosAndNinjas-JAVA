package com.javier.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javier.models.Dojo;
import com.javier.repositories.DojoRepository;


@Service
public class DojoService {
	private final DojoRepository dojoRepo;
	
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public List <Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	public Dojo findDojoById(int id) {
		Optional<Dojo> optionalDojo= dojoRepo.findById(id);
		if (optionalDojo.isPresent() ){
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
	
	public Dojo createDojo(Dojo dojo){
		return dojoRepo.save(dojo);		
	}
}


