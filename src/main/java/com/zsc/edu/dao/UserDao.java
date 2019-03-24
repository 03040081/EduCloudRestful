package com.zsc.edu.dao;

import com.zsc.edu.entity.OrderInfo;
import com.zsc.edu.entity.Schedule;
import com.zsc.edu.entity.User;
import com.zsc.edu.entity.VideoInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

	/*
	 * ע��
	 */
	public int SignUp(User user);
	
	/*
	 * ��¼
	 */
	public User Login(User user);
	
	/*
	 * �ύ����
	 */
	public int SubmitOrder(OrderInfo orderInfo);
	
	/*
	 * ��ɶ�����������ɣ�
	 */
	public void CompleteOrder(int orderId);
	
	/*
	 * ���˶�����Ϣ
	 */
	public List<OrderInfo> ListOrderInfo(int userId);
	
	//public List<VideoInfo> OrderVideo(int userId);
	
	public VideoInfo OrderVideo(int videoId);
	
	public int addSchedule(Schedule schedule);
	
	public List<Schedule> getUserSchedule(int userId);
}
