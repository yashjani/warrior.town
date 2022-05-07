package com.thewarriors.us.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.thewarriors.us.entity.SumoLayer;

public interface SumoLayerRepository  extends CrudRepository<SumoLayer, Long> {
	
	public SumoLayer findByDescriptionAndName(String description, String name);
	
	@Query("SELECT p FROM SumoLayer p WHERE p.name = :name and p.description IN (:descriptions)")
	List<SumoLayer> findByTypeAndDescription(String name, List<String> descriptions);
}
