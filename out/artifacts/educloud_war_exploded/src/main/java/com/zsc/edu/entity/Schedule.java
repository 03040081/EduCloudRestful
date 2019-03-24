package com.zsc.edu.entity;

public class Schedule {

	private int scheduleId;
	private int userId;
	private VideoInfo videoInfo;

	public Schedule(int scheduleId, int userId, VideoInfo videoInfo) {
		this.scheduleId = scheduleId;
		this.userId = userId;
		this.videoInfo = videoInfo;
	}

	public Schedule() {
	}
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public VideoInfo getVideoInfo() {
		return videoInfo;
	}
	public void setVideoInfo(VideoInfo videoInfo) {
		this.videoInfo = videoInfo;
	}
}
