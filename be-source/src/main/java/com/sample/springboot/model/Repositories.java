package com.sample.springboot.model;

import java.util.List;

public class Repositories {

	private long totalCount;
	
	private Boolean incompleteResults;
	
	private List<Item> items;

	/**
	 * @return the totalCount
	 */
	public long getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the incompleteResults
	 */
	public Boolean getIncompleteResults() {
		return incompleteResults;
	}

	/**
	 * @param incompleteResults the incompleteResults to set
	 */
	public void setIncompleteResults(Boolean incompleteResults) {
		this.incompleteResults = incompleteResults;
	}

	/**
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
}
