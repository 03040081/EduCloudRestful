package com.zsc.edu.dao;

import com.zsc.edu.entity.CategoryDetailed;
import com.zsc.edu.entity.Major;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VideoClassifyDao {

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
