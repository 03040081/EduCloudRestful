package com.zsc.edu.entity;

public class Forum {
	
	private int forumId;
	private int videoId;
	private String contents;
	
	private User user;

	public Forum(int forumId, int videoId, String contents, User user) {
		this.forumId = forumId;
		this.videoId = videoId;
		this.contents = contents;
		this.user = user;
	}

	public Forum() {
	}

	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
