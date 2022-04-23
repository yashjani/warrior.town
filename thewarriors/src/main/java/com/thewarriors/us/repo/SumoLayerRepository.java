package com.thewarriors.us.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.thewarriors.us.entity.SumoLayer;

public interface SumoLayerRepository  extends PagingAndSortingRepository<SumoLayer, Long> {
	
	public SumoLayer findByDescriptionAndName(String description, String name);
	
	@Query("SELECT p FROM SumoLayer p WHERE p.name = :name and p.description IN (:descriptions)")
	Page<SumoLayer> findByTypeAndDescription(String name, List<String> descriptions, Pageable pageable);
}
