package com.thewarriors.us.utility;

import java.util.ArrayList;
import java.util.List;

import com.thewarriors.us.dto.PhotoDto;
import com.thewarriors.us.dto.SumoLayerDto;
import com.thewarriors.us.entity.Photo;
import com.thewarriors.us.entity.SumoLayer;

public class EnitytoDtoConversion {
	
	public static PhotoDto photoDtoconversion(Photo photo, boolean includeDetails) {
		PhotoDto photoDto = new PhotoDto();
		photoDto.setId(String.valueOf(photo.getId()));
		String[] arr = photo.getName().split(" ");
		photoDto.setName(arr[1]+" " + arr[0]);
		//photoDto.setAwsLink("https://d18kpicgcaxrrw.cloudfront.net/thumbnail/"+photo.getId()+".jpg");
		if(includeDetails) {
			List<SumoLayer> sumoLayers = photo.getSumolayers();
			List<SumoLayerDto> details = new ArrayList<>();
			SumoLayerDto sumoLayerDto = null;
			for(SumoLayer sumoLayer : sumoLayers) {
				sumoLayerDto = new SumoLayerDto();
				sumoLayerDto.setDescription(sumoLayer.getDescription());
				sumoLayerDto.setName(sumoLayer.getName());
				details.add(sumoLayerDto);
			}
			photoDto.setOpenseaLink(photo.getOpenseaLink());
			photoDto.setDetails(details);
		}
		return photoDto;
	}
	

}
