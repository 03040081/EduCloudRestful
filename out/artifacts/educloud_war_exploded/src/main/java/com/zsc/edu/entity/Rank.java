package com.zsc.edu.entity;

import java.util.List;

public class Rank {
	
	private int rankId;
	private String rankName;
	private List<VideoInfo> listVideo;
	
	public Rank(){}
	
	public Rank(int rankId, String rankName, List<VideoInfo> listVideo) {
		this.rankId = rankId;
		this.rankName = rankName;
		this.listVideo = listVideo;
	}


	public int getRankId() {
		return rankId;
	}
	public void setRankId(int rankId) {
		this.rankId = rankId;
	}
	public String getRankName() {
		return rankName;
	}
	public void setRankName(String rankName) {
		this.rankName = rankName;
	}
	public List<VideoInfo> getListVideo() {
		return listVideo;
	}
	public void setListVideo(List<VideoInfo> listVideo) {
		this.listVideo = listVideo;
	}
	
	
}
