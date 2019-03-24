package com.zsc.edu.entity;

import java.util.List;

public class CategoryDetailed {

	private int cgdetailedId;
	private String cgdetailedName;

	public CategoryDetailed(int cgdetailedId, String cgdetailedName) {
		this.cgdetailedId = cgdetailedId;
		this.cgdetailedName = cgdetailedName;
	}

	public CategoryDetailed() {
	}

	public int getCgdetailedId() {
		return cgdetailedId;
	}

	public void setCgdetailedId(int cgdetailedId) {
		this.cgdetailedId = cgdetailedId;
	}

	public String getCgdetailedName() {
		return cgdetailedName;
	}

	public void setCgdetailedName(String cgdetailedName) {
		this.cgdetailedName = cgdetailedName;
	}
	
}
