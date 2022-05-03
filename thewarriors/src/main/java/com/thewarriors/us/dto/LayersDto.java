package com.thewarriors.us.dto;

import java.util.ArrayList;
import java.util.List;

public class LayersDto {

	private String layerType;
	private List<LayerDto> layers = new ArrayList<>();

	
	public String getLayerType() {
		return layerType;
	}

	public void setLayerType(String layerType) {
		this.layerType = layerType;
	}

	public List<LayerDto> getLayers() {
		return layers;
	}

	public void setLayers(List<LayerDto> layers) {
		this.layers = layers;
	}

}
