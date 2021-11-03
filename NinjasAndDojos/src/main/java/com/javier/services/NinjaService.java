package com.javier.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javier.models.Ninja;
import com.javier.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepo;
		
		public NinjaService(NinjaRepository ninjaRepo) {
			this.ninjaRepo = ninjaRepo;
		}
		
		public Ninja createNinja(Ninja ninja){
			return ninjaRepo.save(ninja);		
		}
}


