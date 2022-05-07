package com.thewarriors.us.dto;

import java.util.List;

public class PhotoDto {

	private String id;
	private String name;
	private String openseaLink;
	private List<SumoLayerDto> details;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpenseaLink() {
		return openseaLink;
	}

	public void setOpenseaLink(String openseaLink) {
		this.openseaLink = openseaLink;
	}

	public List<SumoLayerDto> getDetails() {
		return details;
	}

	public void setDetails(List<SumoLayerDto> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "PhotoDto [id=" + id + ", name=" + name + ", openseaLink=" + openseaLink + ", details=" + details + "]";
	}

	
}
