package com.zsc.edu.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zsc.edu.entity.*;
import com.zsc.edu.service.UserBiz;
import com.zsc.edu.utils.CookieTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;


@Controller
public class UserController {

	@Autowired
	UserBiz biz;
/*	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;*/

	@RequestMapping(value="/RegisterUser")
	@ResponseBody
	public VideoHttpResponse<Integer> RegisterUser(@RequestParam("userName")String userName,
												   @RequestParam("userAccount")String userAccount,
												   @RequestParam("userPass")String userPass,
												   @RequestParam("code")String code,
												   HttpServletRequest request){
		VideoHttpResponse<Integer> videoHttpResponse=new VideoHttpResponse<Integer>();
		try{
			HttpSession session=request.getSession();
			String cofCode=(String) session.getAttribute("code");
			if(cofCode.equals(code)){
				//System.out.println(cofCode+"   &   "+code);
				User user=new User();
				RoleInfo role=new RoleInfo();
				user.setUserName(userName);
				role.setRoleId(1);
				user.setRole(role);
				user.setUserAccount(userAccount);
				user.setUserPass(userPass);
				int flag=biz.SignUp(user);
				videoHttpResponse.setRet(flag);
				videoHttpResponse.setCode(200);
				//session.removeAttribute("code");
			}else{
				videoHttpResponse.setMsg("��֤�����");
			}
		}catch(Exception e){
			videoHttpResponse.setMsg(e.getMessage());
		}
		return videoHttpResponse;
	}

	@RequestMapping("/Login")
	@ResponseBody
	public VideoHttpResponse<User> Login(@RequestParam("userAccount")String userAccount,
			@RequestParam("userPass")String userPass,
			HttpServletResponse response){
		User logUser=null;
		VideoHttpResponse<User> videoHttpResponse=new VideoHttpResponse<User>();
		try{
			logUser=new User();
			logUser.setUserAccount(userAccount);
			logUser.setUserPass(userPass);
			User user=biz.Login(logUser);
			if(user!=null){
				String token=user.getUserAccount();////////////
				user.setToken(token);
				CookieTools.writeCookie("token", token, response);
				
			}
			videoHttpResponse.setRet(user);
			videoHttpResponse.setCode(200);
		}catch(Exception e){
			videoHttpResponse.setMsg(e.getMessage());
		}
		return videoHttpResponse;
	}

	@RequestMapping(value="/test")
	public ModelAndView ttt(){
		System.out.print("QQQQQQQQQQQQQQQQQQQQQ");
		return new ModelAndView("MyJsp");
	}

	@RequestMapping("/strjsp")
	public String aaa(){
		return "MyJsp";
	}

	@RequestMapping("/order")
	@ResponseBody
	public VideoHttpResponse<List<OrderInfo>> OrderTest(
			@RequestParam("userId")int userId,
			//@RequestParam("token")String token,
			HttpServletRequest request){
		VideoHttpResponse<List<OrderInfo>> videoHttpResponse=new VideoHttpResponse<List<OrderInfo>>();
		try{
			//String tokenCookie=CookieTools.getCookieValue("token", request);
			if(true){
				List<OrderInfo> list=biz.listOrder(userId);
				videoHttpResponse.setRet(list);
				videoHttpResponse.setCode(200);
			}else{
				videoHttpResponse.setMsg("���ȵ�¼");
			}
		}catch(Exception e){
			videoHttpResponse.setMsg(e.getMessage());
		}

		return videoHttpResponse;
	}

	@RequestMapping("/SubmitOrder")
	@ResponseBody
	public VideoHttpResponse<Boolean> SubmitOrder(
			@RequestParam("userId")int userId,
			@RequestParam("videoId")int videoId,
			//@RequestParam("token")String token,
			HttpServletRequest request){
		VideoHttpResponse<Boolean> videoHttpResponse=null;
		OrderInfo orderInfo=null;
		try{
			//String tokenCookie=CookieTools.getCookieValue("token", request);
			if(true){
				orderInfo=new OrderInfo();
				VideoInfo videoInfo=new VideoInfo();
				videoInfo.setVideoId(videoId);
				orderInfo.setUserId(userId);
				orderInfo.setVideoInfo(videoInfo);
				orderInfo.setOrderState(1);
				biz.SubmitOrder(orderInfo);
				videoHttpResponse.setCode(200);
				videoHttpResponse.setRet(true);
			}else{
				videoHttpResponse.setMsg("���ȵ�¼");
				videoHttpResponse.setRet(false);
			}
		}catch(Exception exception){
			videoHttpResponse.setMsg(exception.getMessage());
		}
		return videoHttpResponse;
	}

	@RequestMapping("/addSchedule")
	@ResponseBody
	public VideoHttpResponse<Boolean> addSchedule(
			@RequestParam("userId")int userId,
			//@RequestParam("token")String token,
			@RequestParam("videoId")int videoId){
		VideoHttpResponse<Boolean> videoHttpResponse=new VideoHttpResponse<Boolean>();
		VideoInfo videoInfo=null;
		Schedule schedule=null;
		try{
			//String tokenCookie=CookieTools.getCookieValue("token", request);
			if(true){
				videoInfo=new VideoInfo();
				videoInfo.setVideoId(videoId);
				schedule=new Schedule();
				schedule.setUserId(userId);
				schedule.setVideoInfo(videoInfo);
				boolean flag=biz.addSchedule(schedule)>0?true:false;
				videoHttpResponse.setCode(200);
				videoHttpResponse.setRet(flag);
			}else{
				videoHttpResponse.setMsg("���ȵ�¼");
				videoHttpResponse.setRet(false);
			}
		}catch(Exception exception){
			videoHttpResponse.setMsg(exception.getMessage());
		}
		return videoHttpResponse;
	}

	@RequestMapping("/getUserSchedule")
	@ResponseBody
	public VideoHttpResponse<List<Schedule>> getUserSchedule(
			@RequestParam("userId")int userId){
		VideoHttpResponse<List<Schedule>> videoHttpResponse=null;
		try {
			videoHttpResponse=new VideoHttpResponse<List<Schedule>>();
			List<Schedule> list=biz.getUserSchedule(userId);
			videoHttpResponse.setRet(list);
			videoHttpResponse.setCode(200);
		} catch (Exception e) {
			videoHttpResponse.setMsg(e.getMessage());
		}
		return videoHttpResponse;
	}
	@RequestMapping("/LoginOut")
	public void LoginOut(HttpServletRequest request){

	}

	@RequestMapping("/confirmation")
	@ResponseBody
	public VideoHttpResponse<Integer> Confirm(@RequestParam("phone")String phone,
			HttpServletRequest request)throws ClientException{
		VideoHttpResponse<Integer> videoHttpResponse=new VideoHttpResponse<Integer>();
		
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");
		final String accessKeyId="LTAIm0OCrrP0wKtB";
		final String accessKeySecret="yXcMkQ5K9lYEjGbyqmJ5jOzYBhJ7Dv";
		IClientProfile profile=DefaultProfile.getProfile("cn-hangzhou",
				accessKeyId,accessKeySecret);
		DefaultProfile.addEndpoint("cn-hangzhou", 
				"cn-hangzhou", "Dysmsapi", "dysmsapi.aliyuncs.com");
		IAcsClient acsClient = new DefaultAcsClient(profile);//�����޸�  
		SendSmsRequest requestSR = new SendSmsRequest();//�����޸�  
		requestSR.setPhoneNumbers(phone);
		requestSR.setSignName("��ɽѧԺ�ƿ���");
		requestSR.setTemplateCode("SMS_126585246");
		int cd=(int) ((Math.random()*9+1)*100000);
		String code=String.valueOf(cd);
		//System.out.print(code);
		requestSR.setTemplateParam("{\"code\":\""+code+"\"}");
		HttpSession session=request.getSession();
		session.setAttribute("code", code);
		SendSmsResponse sendSmsResponse=acsClient.getAcsResponse(requestSR);
		if(sendSmsResponse.getCode()!=null&&sendSmsResponse.getCode().equals("Ok")){
			videoHttpResponse.setCode(200);
			
			return videoHttpResponse;
		}else{
			videoHttpResponse.setMsg("��ȡ��֤��ʧ��");
			return videoHttpResponse;
		}
		
	}
}
