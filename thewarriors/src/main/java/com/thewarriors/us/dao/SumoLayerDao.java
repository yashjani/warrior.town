package com.thewarriors.us.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.thewarriors.us.dto.LayerDto;
import com.thewarriors.us.dto.LayersDto;
import com.thewarriors.us.entity.SumoLayer;
import com.thewarriors.us.repo.SumoLayerRepository;

@Service
public class SumoLayerDao {
	
	@Autowired
	SumoLayerRepository sumoLayerRepository;
	
	@Async
	public void getSumoLayers(List<LayersDto> layers){
		List<SumoLayer> sumoLayers = new ArrayList<>();

		for(LayersDto layersDto : layers) {
			for(LayerDto layerDto : layersDto.getLayers()) {
				sumoLayers.addAll(sumoLayerRepository.findByTypeAndDescription(layersDto.getLayerType(), layerDto.getLayerName()));
			}
		}
	}

}
