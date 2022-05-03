package com.thewarriors.us.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.thewarriors.us.dto.LayerDto;
import com.thewarriors.us.dto.LayersDto;
import com.thewarriors.us.dto.PhotoDto;
import com.thewarriors.us.dto.SkinToneDto;
import com.thewarriors.us.entity.Photo;
import com.thewarriors.us.entity.SumoLayer;
import com.thewarriors.us.repo.PhotoRepository;
import com.thewarriors.us.repo.SumoLayerRepository;
import com.thewarriors.us.utility.LayerConstants;
import com.thewarriors.us.utility.EnitytoDtoConversion;

@Service
public class MetadataService {
	
	@Autowired
	SumoLayerRepository sumoLayerRepository;
	
	@Autowired
	PhotoRepository photoRepository;
	
	
	
	public String createJSONObject(Photo photo, Stack<Map.Entry<String, String>> stack, String type, String skinColor) {
		JSONObject jsonObject = new JSONObject();
		List<SumoLayer> sumoLayers = new ArrayList<>();
		SumoLayer sumoLayer = null;
		for(Map.Entry<String, String> entry : stack) {
			String key = entry.getKey();
			String value =  entry.getValue();
			if(!key.equals("Back_Weapon") && (key.contains("glow") || key.contains("_") || value.contains("_"))) {
				continue;
			}
			key = key.replace("_", " ").replace(".svg", "").toUpperCase();
			value = value.replace("_", " ").replace(".svg", "").toUpperCase();
			sumoLayer = sumoLayerRepository.findByDescriptionAndName(value,key);
			sumoLayers.add(sumoLayer);
			jsonObject.put(key, value);
		}
		sumoLayer = sumoLayerRepository.findByDescriptionAndName(skinColor,LayerConstants.COLOR);
		sumoLayers.add(sumoLayer);
		sumoLayer = sumoLayerRepository.findByDescriptionAndName(type,LayerConstants.TYPE);
		sumoLayers.add(sumoLayer);
		saveRelation(photo,sumoLayers);
		jsonObject.put(LayerConstants.TYPE, type);
		jsonObject.put(LayerConstants.COLOR, skinColor);
		return jsonObject.toString();
	}
	
	public void saveRelation(Photo photo, List<SumoLayer> sumoLayers) {
		photo.setSumolayers(sumoLayers);
		photo.setUsed(true);
		photoRepository.save(photo);
	}
	
	public void addNewLayers() {
		//Adding type (Gold,silver and bronze as layer)
		for(String type : LayerConstants.types) {
			SumoLayer sumoLayer = sumoLayerRepository.findByDescriptionAndName(type,LayerConstants.TYPE);
			if(sumoLayer != null) {
				continue;
			}
			sumoLayer = new SumoLayer();
			sumoLayer.setDescription(type);
			sumoLayer.setName(LayerConstants.TYPE);
			sumoLayerRepository.save(sumoLayer);
		}
		SumoLayer sumoLayer = null;
        for(String type : LayerConstants.types) {
        	File root = new File("./sumo/" + type + "/layer/");
        	File[] listOfFilesAndDirectory = root.listFiles();
        	for(File layerFile : listOfFilesAndDirectory) {
        		if(layerFile == null || layerFile.isHidden()) { 
        			layerFile.delete();
        			continue;
        		}
        		File[] files = layerFile.listFiles();
        		//Adding folder as type and files as description in layer table
        		for(File file : files) {
	        		String separator = "\\";
					String[] arr = file.getPath().replaceAll(Pattern.quote(separator), "\\\\").split("/");
					int length = arr.length;
					String layerType = arr[length - 2].replace(".svg", "");
					String layerName = arr[length - 1].replace(".svg", "");
					if((layerName.contains("_") && !layerType.equalsIgnoreCase("Back_Weapon"))  || layerName.contains(".DS")) {
						continue;
					}
					layerType = layerType.replace("_", " ").toUpperCase();
					layerName = layerName.replace("_", " ").toUpperCase();
					sumoLayer = sumoLayerRepository.findByDescriptionAndName(layerName, layerType);
					if(sumoLayer != null) {
						continue;
					}
					sumoLayer = new SumoLayer();
					sumoLayer.setDescription(layerName);
					sumoLayer.setName(layerType);
					sumoLayerRepository.save(sumoLayer);
				}
        	}
        	//add color as layer
        	List<SkinToneDto> skinTone = LayerConstants.skinColorTone.get(type);
        	for(SkinToneDto skinToneDto : skinTone) {
        		sumoLayer = sumoLayerRepository.findByDescriptionAndName(skinToneDto.getColorName().toUpperCase(), LayerConstants.COLOR);
				if(sumoLayer != null) {
					continue;
				}
				sumoLayer = new SumoLayer();
				sumoLayer.setDescription(skinToneDto.getColorName().toUpperCase());
				sumoLayer.setName(LayerConstants.COLOR);
				sumoLayerRepository.save(sumoLayer);
        	}
        	
		}
       
	}
	
	@Cacheable("layers")
	public List<LayersDto> getLayers() {
		Iterable<SumoLayer> sumoLayers = sumoLayerRepository.findAll();
		LayersDto layersDto = null;
		LayerDto layerDto = null;
		Map<String, LayersDto> map = new HashMap<>();
		for(SumoLayer sumoLayer : sumoLayers) {
			if(!map.containsKey(sumoLayer.getName())){
				layersDto = new LayersDto();
				layersDto.setLayerType(sumoLayer.getName());
				map.put(sumoLayer.getName(), layersDto);
			}
			layerDto = new LayerDto();
			layerDto.setLayerName(sumoLayer.getDescription());
			layerDto.setCount(sumoLayer.getPhotos().size());
			map.get(sumoLayer.getName()).getLayers().add(layerDto);
		}
		return new ArrayList<>(map.values());

	}
	
	public PhotoDto getPhotoDetails(int photoId){
		Photo photo = photoRepository.findById((long)photoId).get();
		if(photo == null) return null;
		return EnitytoDtoConversion.photoDtoconversion(photo, true);
	}

}
