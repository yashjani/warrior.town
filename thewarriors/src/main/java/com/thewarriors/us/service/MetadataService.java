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
import org.springframework.stereotype.Service;

import com.thewarriors.us.dto.PhotoDto;
import com.thewarriors.us.entity.Photo;
import com.thewarriors.us.entity.SumoLayer;
import com.thewarriors.us.repo.PhotoRepository;
import com.thewarriors.us.repo.SumoLayerRepository;
import com.thewarriors.us.utility.EnitytoDtoConversion;

@Service
public class MetadataService {
	
	@Autowired
	SumoLayerRepository sumoLayerRepository;
	
	@Autowired
	PhotoRepository photoRepository;
	
	
	
	public String createJSONObject(Photo photo, Stack<Map.Entry<String, String>> stack, String type) {
		JSONObject jsonObject = new JSONObject();
		List<SumoLayer> sumoLayers = new ArrayList<>();
		SumoLayer sumoLayer = null;
		for(Map.Entry<String, String> entry : stack) {
			String key = entry.getKey();
			String value =  entry.getValue();
			if(key.contains("Body_glow") || key.contains("Gold_glow")) {
				continue;
			}
			key = key.replace("_", " ").replace(".svg", "");
			value = value.replace("_", " ").replace(".svg", "");
			sumoLayer = sumoLayerRepository.findByDescriptionAndName(value,key);
			sumoLayers.add(sumoLayer);
			jsonObject.put(key, value);
		}
		jsonObject.put("Type", type);
		saveRelation(photo,sumoLayers);
		return jsonObject.toString();
	}
	
	public void saveRelation(Photo photo, List<SumoLayer> sumoLayers) {
		photo.setSumolayers(sumoLayers);
		photo.setUsed(true);
		photoRepository.save(photo);
	}
	
	public void addNewLayers() {
		String[] types = {"Gold", "Silver", "Bronze"};
		SumoLayer sumoLayer = null;
        for(String type : types) {
        	File root = new File("./sumo/" + type + "/layer/");
        	File[] listOfFilesAndDirectory = root.listFiles();
        	for(File layerFile : listOfFilesAndDirectory) {
        		if(layerFile == null || layerFile.isHidden()) { 
        			layerFile.delete();
        			continue;
        		}
        		File[] files = layerFile.listFiles();
        		for(File file : files) {
	        		String separator = "\\";
					String[] arr = file.getPath().replaceAll(Pattern.quote(separator), "\\\\").split("/");
					int length = arr.length;
					String layerType = arr[length - 2].replace("_", " ").replace(".svg", "");
					String layerName = arr[length - 1].replace("_", " ").replace(".svg", "");
					sumoLayer = sumoLayerRepository.findByDescriptionAndName(layerName, layerType);
					if(sumoLayer != null || layerName.contains("glow") || layerName.contains(".DS")) {
						continue;
					}
					sumoLayer = new SumoLayer();
					sumoLayer.setDescription(layerName);
					sumoLayer.setName(layerType);
					sumoLayerRepository.save(sumoLayer);
				}
        	}
		}
       
	}
	
	
	public Map<String, List<String>> getLayers() {
		Iterable<SumoLayer> sumoLayers = sumoLayerRepository.findAll();
		Map<String, List<String>> sumoLayerResponse = new HashMap<>();
		for(SumoLayer sumoLayer : sumoLayers) {
			if(!sumoLayerResponse.containsKey(sumoLayer.getName())) {
				sumoLayerResponse.put(sumoLayer.getName(), new ArrayList<>());
			}
			sumoLayerResponse.get(sumoLayer.getName()).add(sumoLayer.getDescription());
		}
		return sumoLayerResponse;
	}
	
	public PhotoDto getPhotoDetails(int photoId){
		Photo photo = photoRepository.findById((long)photoId).get();
		if(photo == null) return null;
		return EnitytoDtoConversion.photoDtoconversion(photo, true);
	}

}
