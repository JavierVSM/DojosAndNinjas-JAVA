package com.javier.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javier.models.Dojo;
import com.javier.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository <Ninja, Long >{
	List<Ninja> findByDojo_Id(Long id);
	Optional <Ninja> findById(int id);
	Ninja save (Ninja ninja);
}