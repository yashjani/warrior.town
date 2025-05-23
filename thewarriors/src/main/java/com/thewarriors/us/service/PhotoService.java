package com.thewarriors.us.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thewarriors.us.dao.SumoLayerDao;
import com.thewarriors.us.dto.FilterDto;
import com.thewarriors.us.dto.PhotoDto;
import com.thewarriors.us.dto.PhotoFilterRquest;
import com.thewarriors.us.entity.Photo;
import com.thewarriors.us.entity.SumoLayer;
import com.thewarriors.us.repo.PhotoRepository;
import com.thewarriors.us.repo.SumoLayerRepository;
import com.thewarriors.us.utility.EnitytoDtoConversion;

@Service
@Transactional
public class PhotoService {

	@Autowired
	PhotoRepository photoRepository;

	@Autowired
	SumoLayerDao dumoLayerDao;

	@Autowired
	CacheManager cacheManager;

	@Autowired
	SumoLayerRepository sumoLayerRepository;

	public void saveName() throws IOException {
		File file = new File("./name.txt");
		String names = null;
			//	Files.readString(Path.of(file.getPath()));
		String[] nameArr = names.split(",");
		String[] types = { "Gold", "Silver", "Bronze" };
		Set<String> nameSet = new HashSet<>();
		for (String name : nameArr) {
			name = name.trim();
			if (name.contains(" ")) {
				name = name.substring(0, name.indexOf(" "));
			}
			if (nameSet.contains(name)) {
				continue;
			}
			nameSet.add(name);
			for (String type : types) {
				String newName = name;
				Photo photo = new Photo();
				newName = type + " " + newName;
				photo.setName(newName);
				photo.setType(type);
				try {
					photoRepository.save(photo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public Photo getUnUsedPhoto(String type) {
		return photoRepository.findFirstByTypeAndIsUsed(type, false);
	}

	public void savePhoto(Photo photo) {
		photoRepository.save(photo);
	}

	public List<PhotoDto> getPhotos(PhotoFilterRquest photoFilterRquest) {
		List<PhotoDto> resultPhoto = new ArrayList<>();
		Set<Long> photoIds = new HashSet<>();
		if (photoFilterRquest == null || photoFilterRquest.getFilters() == null
				|| photoFilterRquest.getFilters().isEmpty()) {
			List<Photo> photoList = photoRepository.findByIsUsed(true);
			for (Photo photo : photoList) {
				resultPhoto.add(EnitytoDtoConversion.photoDtoconversion(photo, false));
			}
		} else {
			List<FilterDto> filters = photoFilterRquest.getFilters();
			for (FilterDto filter : filters) {
				if (filter.getFilterName() == null || filter.getFilterName().isEmpty()
						|| filter.getFilterType() == null) {
					continue;
				}
				List<SumoLayer> sumoLayers = new ArrayList<>();
				for (String filterName : filter.getFilterName()) {
					sumoLayers.addAll(sumoLayerRepository.findByTypeAndDescription(filter.getFilterType(), filterName));
				}

				for (SumoLayer layer : sumoLayers) {
					for (Photo photo : layer.getPhotos()) {
						if (!photoIds.contains(photo.getId())) {
							resultPhoto.add(EnitytoDtoConversion.photoDtoconversion(photo, false));
						}
						photoIds.add(photo.getId());
					}
				}
			}
		}

		return resultPhoto;
	}

}
