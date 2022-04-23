package com.thewarriors.us.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhotoFilterRquest {

	private Map<String, List<String>> filters = new HashMap<>();
	private int pageNumber = 0;

	public Map<String, List<String>> getFilters() {
		return filters;
	}

	public void setFilters(Map<String, List<String>> filters) {
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
