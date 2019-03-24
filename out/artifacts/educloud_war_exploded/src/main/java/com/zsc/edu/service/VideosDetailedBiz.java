package com.zsc.edu.service;

import com.zsc.edu.entity.Forum;
import com.zsc.edu.entity.VideoAssess;
import com.zsc.edu.entity.VideoChapter;
import com.zsc.edu.entity.VideoInfo;

import java.util.List;
import java.util.Map;


public interface VideosDetailedBiz {

	public int publishVideo(VideoInfo videoInfo);
	
	public List<VideoAssess> videoAssessesList(Map map);
	
	public List<Forum> forumsList(Map map);
	
	public void publishAssess(VideoAssess videoAssess);
	
	public void publishForum(Forum forum);
	
	public int publishChapter(VideoChapter videoChapter);
	
	public VideoInfo getVideoDetailed(int videoId);
	
	public int publishChapterDetaileds(VideoChapter videoChapter);
	
	/*
	 * ��ȡ�γ̵�
	 * VideoAssess����  �ܼ�¼��---------
	 */
	public int getTotalRecordsAssess(int videoId);
	
	/*
	 * ��ȡ�γ̵�
	 * Forum��ѯ �ܼ�¼��----------
	 */
	public int getTotalRecordsForum(int videoId);
}
