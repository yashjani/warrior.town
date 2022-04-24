package com.thewarriors.us.dto;

import java.util.ArrayList;
import java.util.List;

public class FilterDto {

	private String filterType;
	private List<String> filterName = new ArrayList<>();

	public String getFilterType() {
		return filterType;
	}

	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}

	public List<String> getFilterName() {
		return filterName;
	}

	public void setFilterName(List<String> filterName) {
		this.filterName = filterName;
	}

	@Override
	public String toString() {
		return "FilterDto [filterType=" + filterType + ", filterName=" + filterName + "]";
	}

}
