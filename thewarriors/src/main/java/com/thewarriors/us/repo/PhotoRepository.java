package com.thewarriors.us.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.thewarriors.us.entity.Photo;

public interface PhotoRepository extends PagingAndSortingRepository<Photo, Long>{
	
	Photo findFirstByTypeAndIsUsed(String type, boolean isUsed);
	Photo findByName(String name);
}
