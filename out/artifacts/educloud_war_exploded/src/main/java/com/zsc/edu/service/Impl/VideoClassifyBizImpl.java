package com.zsc.edu.service.Impl;

import java.util.List;

import com.zsc.edu.dao.VideoClassifyDao;
import com.zsc.edu.entity.CategoryDetailed;
import com.zsc.edu.entity.Major;
import com.zsc.edu.service.VideoClassifyBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("VideoClassifyBiz")
public class VideoClassifyBizImpl implements VideoClassifyBiz {

	@Autowired
	VideoClassifyDao dao;
	
	@Override
	public List<Major> getMajors() {
		// TODO Auto-generated method stub
		return dao.getMajors();
	}

	@Override
	public List<CategoryDetailed> getCategoryDetaileds(int categoryId) {
		// TODO Auto-generated method stub
		return dao.getCategoryDetaileds(categoryId);
	}

}
