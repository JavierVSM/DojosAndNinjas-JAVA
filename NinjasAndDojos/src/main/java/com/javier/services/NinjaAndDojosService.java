package com.javier.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javier.models.Dojo;
import com.javier.models.Ninja;
import com.javier.repositories.DojoRepository;
import com.javier.repositories.NinjaRepository;

@Service
public class NinjaAndDojosService {
	private DojoRepository dojoRepo;
	private NinjaRepository ninjaRepo;
	
	public NinjaAndDojosService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	public List <Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	public Dojo findDojoById(Long exampleId) {
		Optional<Dojo> optionalDojo= dojoRepo.findById(exampleId);
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
	
	public Ninja createNinja(Ninja ninja){
		return ninjaRepo.save(ninja);		
	}

	public List<Ninja> allNinjasByDojo(Long id) {
		return ninjaRepo.findByDojo_Id(id);
	}

}
