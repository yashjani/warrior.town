package com.thewarriors.us.repo;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import com.thewarriors.us.entity.Photo;

public interface PhotoRepository extends CrudRepository<Photo, Long>{
	
	Photo findFirstByTypeAndIsUsed(String type, boolean isUsed);
	
	Photo findByName(String name);
	
	@Cacheable("isUsed")
	List<Photo> findByIsUsed(boolean isUsed);
	
}
