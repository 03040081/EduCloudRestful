package com.zsc.edu.entity;

import java.util.List;

public class Major {
	private int majorId;
	private String majorName;
	private List<Category> categoryList;

	public Major(int majorId, String majorName, List<Category> categoryList) {

		this.majorId = majorId;
		this.majorName = majorName;
		this.categoryList = categoryList;
	}
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	public Major() {
	}
	public int getMajorId() {
		return majorId;
	}
	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	
}
