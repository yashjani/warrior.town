package com.thewarriors.us.dto;

public class LayerDto {

	private String layerName;
	private int count;
	private boolean checked = false;

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
	
	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "LayerDto [layerName=" + layerName + ", count=" + count + ", checked=" + checked + "]";
	}

}
