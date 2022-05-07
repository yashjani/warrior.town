package com.thewarriors.us.repo;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.thewarriors.us.entity.SumoLayer;

public interface SumoLayerRepository  extends CrudRepository<SumoLayer, Long> {
	
	public SumoLayer findByDescriptionAndName(String description, String name);
	
	@Query("SELECT p FROM SumoLayer p WHERE p.name = :name and p.description IN (:descriptions)")
	@Cacheable(cacheNames = {"findByTypeAndDescriptions"}, key= "#name + #descriptions.toString()")
	List<SumoLayer> findByTypeAndDescriptions(String name, List<String> descriptions);
	
	@Query("SELECT p FROM SumoLayer p WHERE p.name = :name and p.description = :description")
	@Cacheable(value={"findByTypeAndDescription"}, key= "#name + #description")
	List<SumoLayer> findByTypeAndDescription(String name, String description);
	
}
