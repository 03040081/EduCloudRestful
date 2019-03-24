package com.zsc.edu.service;

import com.zsc.edu.entity.CategoryDetailed;
import com.zsc.edu.entity.Major;

import java.util.List;

public interface VideoClassifyBiz {

	/*
	 * ��ȡ����רҵ����רҵ�е�����
	 * Major & Category
	 */
	public List<Major> getMajors();
	
	/*
	 * ��ȡ��ϸ����
	 */
	public List<CategoryDetailed> getCategoryDetaileds(int categoryId);
}
