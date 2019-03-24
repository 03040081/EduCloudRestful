/*
package com.zsc.edu.dao;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;
import zsc.gof.entity.OrderInfo;
import zsc.gof.entity.RoleInfo;
import zsc.gof.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/application*.xml")


public class TestJun {

	@Autowired
	UserDao dao;
	
	@Test public void testSignUp(){
		List<OrderInfo> list=dao.ListOrderInfo(1);
		
		for (OrderInfo orderInfo : list) {
			System.out.print(list.get(0).getVideoInfo().getVideoTile());
		}
	}
	@Test public void testSignUp2(){
		User user=new User();
		user.setUserName("123456789");
		user.setUserPass("123456");
		System.out.print(dao.Login(user));
	}


}
*/
