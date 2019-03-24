package com.zsc.edu.service;

import com.zsc.edu.entity.VideoInfo;

import java.util.List;
import java.util.Map;


public interface AboutVideosBiz {

	/*
	 * ��ȡ�γ�
	 */
	public List<VideoInfo> getVideos(Map<String, Object> map);
	/*
	 * ��ȡ��ѿγ�
	 * price=0
	 */
	public List<VideoInfo> getFreeVideos(Map<String, Object> map);
	
	/*
	 * ��ȡ��ҳ�Ƽ��γ�
	 * recommend=1
	 */
	public List<VideoInfo> getRecommendVideos(Map<String, Object> map);
	
	/*
	 * ���ݱ���videoTile��ȡ�����Ŀγ�
	 * videoTile
	 */
	public List<VideoInfo> searchVideos(Map<String, Object> map);
	
	/*
	 * ��ȡָ��רҵ�γ�
	 * major
	 */
	public List<VideoInfo> smajorVideos(Map<String, Object> map);
	
	/*
	 * ��ȡָ��רҵ�ж�Ӧ����Ŀγ�
	 * major & category
	 */
	public List<VideoInfo> categoryVideos(Map<String, Object> map);
	
	/*
	 * ��ȡָ��רҵ�ж�Ӧ�����רҵ����γ�
	 * major & category & cgdetaliedId
	 */
	public List<VideoInfo> cgdetailedVideos(Map<String, Object> map);
	
	/*
	 * ��ȡ��ѯ��� �ܼ�¼��
	 */
	public int getTotalRecords(Map<String, Object> map);
}
