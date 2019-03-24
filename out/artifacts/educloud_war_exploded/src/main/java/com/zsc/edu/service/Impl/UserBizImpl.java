package com.zsc.edu.service.Impl;

import java.util.List;

import com.zsc.edu.dao.UserDao;
import com.zsc.edu.entity.OrderInfo;
import com.zsc.edu.entity.Schedule;
import com.zsc.edu.entity.User;
import com.zsc.edu.service.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserBiz")
public class UserBizImpl implements UserBiz {

	@Autowired
	UserDao dao;

	@Override
	public int SignUp(User user) {
		// TODO Auto-generated method stub
		return dao.SignUp(user);
	}

	@Override
	public User Login(User user) {
		// TODO Auto-generated method stub
		return dao.Login(user);
	}

	@Override
	public List<OrderInfo> listOrder(int userId) {
		// TODO Auto-generated method stub
		return dao.ListOrderInfo(userId);
	}

	@Override
	public int SubmitOrder(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		return dao.SubmitOrder(orderInfo);
	}

	@Override
	public void CompltetOrder(int orderId) {
		// TODO Auto-generated method stub
		dao.CompleteOrder(orderId);
	}

	@Override
	public int addSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		return dao.addSchedule(schedule);
	}

	@Override
	public List<Schedule> getUserSchedule(int userId) {
		// TODO Auto-generated method stub
		return dao.getUserSchedule(userId);
	}
	
	
}
