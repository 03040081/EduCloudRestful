package com.zsc.edu.dao;

import com.zsc.edu.entity.VideoInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AboutVideosDao {
	
	public List<VideoInfo> getAboutVideos(Map map);
	
	public int getTotalRecords(Map map);
}
