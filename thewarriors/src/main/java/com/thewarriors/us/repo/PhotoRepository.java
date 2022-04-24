package com.thewarriors.us.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.thewarriors.us.entity.Photo;

public interface PhotoRepository extends PagingAndSortingRepository<Photo, Long>{
	
	Photo findFirstByTypeAndIsUsed(String type, boolean isUsed);
	Photo findByName(String name);
	List<Photo> findByIsUsed(boolean isUsed);
	
}
