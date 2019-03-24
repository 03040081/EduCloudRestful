package com.zsc.edu.entity;

import java.util.List;

public class Category {

	private int categoryId;
	private String categoryName;
	private List<CategoryDetailed> categoryDetailedList;
	
	private List<VideoInfo> listVideoInfo;

	public Category(int categoryId, String categoryName, List<CategoryDetailed> categoryDetailedList,
			List<VideoInfo> listVideoInfo) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDetailedList = categoryDetailedList;
		this.listVideoInfo = listVideoInfo;
	}

	public List<CategoryDetailed> getCategoryDetailedList() {
		return categoryDetailedList;
	}

	public void setCategoryDetailedList(List<CategoryDetailed> categoryDetailedList) {
		this.categoryDetailedList = categoryDetailedList;
	}

	public Category() {
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<VideoInfo> getListVideoInfo() {
		return listVideoInfo;
	}

	public void setListVideoInfo(List<VideoInfo> listVideoInfo) {
		this.listVideoInfo = listVideoInfo;
	}
	
	
}
