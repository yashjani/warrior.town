package com.thewarriors.us.dto;

public class SkinToneDto {

	private String colorName;
	private String rgbColor;
	
	

	public SkinToneDto(String colorName, String rgbColor) {
		super();
		this.colorName = colorName;
		this.rgbColor = rgbColor;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getRgbColor() {
		return rgbColor;
	}

	public void setRgbColor(String rgbColor) {
		this.rgbColor = rgbColor;
	}

	@Override
	public String toString() {
		return "SkinToneDto [colorName=" + colorName + ", rgbColor=" + rgbColor + "]";
	}

}
