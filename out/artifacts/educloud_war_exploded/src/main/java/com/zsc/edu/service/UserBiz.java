package com.zsc.edu.service;

import com.zsc.edu.entity.OrderInfo;
import com.zsc.edu.entity.Schedule;
import com.zsc.edu.entity.User;

import java.util.List;

public interface UserBiz {

	public int SignUp(User user);
	
	public User Login(User user);
	
	public List<OrderInfo> listOrder(int userId);
	
	public int SubmitOrder(OrderInfo orderInfo);
	
	public void CompltetOrder(int orderId);
	
	public int addSchedule(Schedule schedule);
	
	public List<Schedule> getUserSchedule(int userId);
}
