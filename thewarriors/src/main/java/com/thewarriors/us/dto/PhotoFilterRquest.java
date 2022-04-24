package com.thewarriors.us.dto;

import java.util.List;

public class PhotoFilterRquest {

	private  List<FilterDto> filters;
	private int pageNumber = 0;

	

	public List<FilterDto> getFilters() {
		return filters;
	}

	public void setFilters(List<FilterDto> filters) {
		this.filters = filters;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public String toString() {
		return "PhotoFilterRquest [filters=" + filters + ", pageNumber=" + pageNumber + "]";
	}

}
