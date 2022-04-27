package com.thewarriors.us.dto;

import java.util.List;

public class PhotoDto {

	private String id;
	private String name;
	private String openseaLink;
	private String awsLink;
	private String backgroundColor;
	private List<SumoLayerDto> details;
	private int pageNumber;

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

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getAwsLink() {
		return awsLink;
	}

	public void setAwsLink(String awsLink) {
		this.awsLink = awsLink;
	}
	
	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	@Override
	public String toString() {
		return "PhotoDto [id=" + id + ", name=" + name + ", openseaLink=" + openseaLink + ", awsLink=" + awsLink
				+ ", backgroundColor=" + backgroundColor + ", details=" + details + ", pageNumber=" + pageNumber + "]";
	}
}
