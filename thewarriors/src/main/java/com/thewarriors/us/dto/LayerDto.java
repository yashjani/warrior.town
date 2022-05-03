package com.thewarriors.us.dto;

public class LayerDto {

	private String layerName;
	private int count;

	public String getLayerName() {
		return layerName;
	}

	public void setLayerName(String layerName) {
		this.layerName = layerName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "LayerDto [layerName=" + layerName + ", count=" + count + "]";
	}

}
