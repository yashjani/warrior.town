package com.thewarriors.us.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thewarriors.us.dto.LayersDto;
import com.thewarriors.us.dto.PhotoDto;
import com.thewarriors.us.dto.PhotoFilterRquest;
import com.thewarriors.us.service.MetadataService;
import com.thewarriors.us.service.PhotoService;


@RestController
@RequestMapping("gallery")
@CrossOrigin(origins = { "https://www.warrior.town","http://127.0.0.1:3000" })
public class ImageController {
	
	
	
	@Autowired
	PhotoService photoService;
	
	@Autowired
	MetadataService metadataService;
		
	@GetMapping(path = "/filters")
	public List<LayersDto>  getSumoFilters(){
		return metadataService.getLayers();
	}
	
	@PostMapping(path = "/photos")
	public List<PhotoDto> getPhotos(@RequestBody PhotoFilterRquest photoFilterRquest){
		return photoService.getPhotos(photoFilterRquest);
	}
	
	@GetMapping(path = "/details")
	public PhotoDto getPhotoDetails(@RequestParam int id) throws Exception{
		return metadataService.getPhotoDetails(id);
	}

}
