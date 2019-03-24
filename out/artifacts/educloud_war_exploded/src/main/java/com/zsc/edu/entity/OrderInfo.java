package com.zsc.edu.entity;

public class OrderInfo {

	private int orderId;
	private int userId;
	private VideoInfo videoInfo;
	private int orderState;

	public OrderInfo(int orderId, int userId, VideoInfo videoInfo, int orderState) {
		this.orderId = orderId;
		this.userId = userId;
		this.videoInfo = videoInfo;
		this.orderState = orderState;
	}
	public OrderInfo() {
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	
}
