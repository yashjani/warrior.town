package com.thewarriors.us.dto;

public class SumoLayerDto {
	String name;
	String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "SumoLayerDto [name=" + name + ", description=" + description + "]";
	}

}
