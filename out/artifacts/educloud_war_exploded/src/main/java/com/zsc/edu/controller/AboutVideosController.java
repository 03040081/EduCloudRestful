package com.zsc.edu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zsc.edu.entity.PageModel;
import com.zsc.edu.entity.VideoHttpResponse;
import com.zsc.edu.entity.VideoInfo;
import com.zsc.edu.service.AboutVideosBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutVideosController {

	@Autowired
	AboutVideosBiz biz;
	/*
	 * ����
	 */
	@RequestMapping("/getVideos")
	public ModelAndView getVideos(){
		ModelAndView modelAndView=null;
		List videoList=null;
		try {
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("indexPage", 0);
			map.put("pageSize", 10);
			videoList=biz.getVideos(map);
			modelAndView=new ModelAndView("MyJsp");
			modelAndView.addObject("videoList",videoList);
		} catch (Exception e) {
			System.out.print(e);
		}
		return modelAndView;
	}

	/*
	 * ��ȡ��ѿγ�
	 * price=0
	 */
	@RequestMapping("/getFreeVideos")
	@ResponseBody
	public VideoHttpResponse<List<VideoInfo>> getFreeVideos(
			@RequestParam("currPage")int currPage,
			@RequestParam("pageSize")int pageSize){
		List<VideoInfo> list=null;
		VideoHttpResponse<List<VideoInfo>> videoHttpResponse=null;
		try{
			videoHttpResponse=new VideoHttpResponse<List<VideoInfo>>();
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("prices", 0);
			map.put("currPage", (currPage-1)*pageSize);
			map.put("pageSize",pageSize);
			list=biz.getFreeVideos(map);
			videoHttpResponse.setRet(list);
			videoHttpResponse.setCode(200);
		}catch(Exception e){
			System.out.println(e);
			videoHttpResponse.setMsg(e.getMessage());
		}
		return videoHttpResponse;
	}
	/*
	 * ��ȡ�Ƽ��γ�
	 */
	@RequestMapping("/getRecommendVideos")
	@ResponseBody
	public VideoHttpResponse<List<VideoInfo>> getRecommendVideos(
			@RequestParam("currPage")int currPage,
			@RequestParam("pageSize")int pageSize){
		VideoHttpResponse<List<VideoInfo>> videoHttpResponse=null;
		List<VideoInfo> list=null;
		try{
			videoHttpResponse=new VideoHttpResponse<List<VideoInfo>>();
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("currPage", (currPage-1)*pageSize);
			map.put("pageSize",pageSize);
			map.put("recommend", 1);
			
			list=biz.getRecommendVideos(map);

			videoHttpResponse.setCode(200);
			videoHttpResponse.setRet(list);
		}catch(Exception e){
			videoHttpResponse.setCode(100);
			videoHttpResponse.setMsg(e.getMessage());
			System.out.println(e);
		}
		return videoHttpResponse;
	}
	
	@RequestMapping("/getRecommentRollVideos")
	@ResponseBody
	public VideoHttpResponse<List<VideoInfo>> getRecommentRollVideos(){
		VideoHttpResponse<List<VideoInfo>> videoHttpResponse=null;
		try {
			videoHttpResponse=new VideoHttpResponse<List<VideoInfo>>();
			videoHttpResponse.setRet(getRollPageVideos());
			videoHttpResponse.setCode(200);
		} catch (Exception e) {
			videoHttpResponse.setMsg(e.getMessage());
		}
		return videoHttpResponse;
	}
	
	private List<VideoInfo> getRollPageVideos(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("recommend", 2);
		return biz.getRecommendVideos(map);
	}
	/*
	 * ͨ��ģ���������ҿγ�
	 */
	@RequestMapping("/searchVideos")
	@ResponseBody
	public VideoHttpResponse<List<VideoInfo>> searchVideos(
			@RequestParam("currPage")int currPage,
			@RequestParam("pageSize")int pageSize,
			@RequestParam("videoTile")String videoTile){
		List<VideoInfo> list=null;
		VideoHttpResponse<List<VideoInfo>> videoHttpResponse=null;
		try{
			videoHttpResponse=new VideoHttpResponse<List<VideoInfo>>();
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("currPage", (currPage-1)*pageSize);
			map.put("pageSize",pageSize);
			map.put("videoTile", videoTile);
			list=biz.searchVideos(map);
			videoHttpResponse.setRet(list);
			videoHttpResponse.setCode(200);
		}catch(Exception e){
			videoHttpResponse.setMsg(e.getMessage());
			System.out.println(e);
		}
		return videoHttpResponse;
	}
	/*
	 * ��ȡָ��רҵ�γ�
	 * major
	 */
	@RequestMapping("/smajorVideos")
	@ResponseBody
	public VideoHttpResponse<List<VideoInfo>> smajorVideos(
			@RequestParam("currPage")int currPage,
			@RequestParam("pageSize")int pageSize,
			@RequestParam("majorId") int majorId){
		List<VideoInfo> list=null;
		VideoHttpResponse<List<VideoInfo>> videoHttpResponse=null;
		try{
			videoHttpResponse=new VideoHttpResponse<List<VideoInfo>>();
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("currPage", (currPage-1)*pageSize);
			map.put("pageSize",pageSize);
			map.put("majorId", majorId);
			list=biz.smajorVideos(map);
			videoHttpResponse.setRet(list);
			videoHttpResponse.setCode(200);
		}catch(Exception e){
			videoHttpResponse.setMsg(e.getMessage());
			System.out.println(e);
		}
		return videoHttpResponse;
	}
	/*
	 * ��ȡָ��רҵ�����Ŀγ�
	 */
	@RequestMapping("/categoryVideos")
	@ResponseBody
	public VideoHttpResponse<List<VideoInfo>> categoryVideos(
			@RequestParam("currPage")int currPage,
			@RequestParam("pageSize")int pageSize,
			@RequestParam("majorId")int majorId,
			@RequestParam("categoryId")int categoryId){
		VideoHttpResponse<List<VideoInfo>> videoHttpResponse=null;
		List<VideoInfo> list=null;
		try {
			Map<String,Object> map=new HashMap<String, Object>();
			videoHttpResponse=new VideoHttpResponse<List<VideoInfo>>();
			map.put("currPage", (currPage-1)*pageSize);
			map.put("pageSize", pageSize);
			map.put("majorId", majorId);
			map.put("categoryId", categoryId);
			list=biz.categoryVideos(map);
			videoHttpResponse.setRet(list);
			videoHttpResponse.setCode(200);
		} catch (Exception e) {
			videoHttpResponse.setMsg(e.getMessage());
			System.out.print(e);
		}
		return videoHttpResponse;
	}
	/*
	 * ��ϸ����еĿγ�
	 */
	@RequestMapping("/cgdetailedVideos")
	@ResponseBody
	public VideoHttpResponse<List<VideoInfo>> cgdetailedVideos(
			@RequestParam("currPage")int currPage,
			@RequestParam("pageSize")int pageSize,
			@RequestParam("majorId")int majorId,
			@RequestParam("categoryId")int categoryId,
			@RequestParam("cgdetailedId")int cgdetaliedId){
		List<VideoInfo> list=null;
		VideoHttpResponse<List<VideoInfo>> videoHttpResponse=null;
		try{
			Map<String,Object> map=new HashMap<String, Object>();
			videoHttpResponse=new VideoHttpResponse<List<VideoInfo>>();
			map.put("currPage", (currPage-1)*pageSize);
			map.put("pageSize", pageSize);
			map.put("majorId", majorId);
			map.put("categoryId", categoryId);
			map.put("cgdetailedId", cgdetaliedId);
			list=biz.cgdetailedVideos(map);
			videoHttpResponse.setRet(list);
			videoHttpResponse.setCode(200);
		}catch(Exception e){
			videoHttpResponse.setMsg(e.getMessage());
			System.out.println(e);
		}
		return videoHttpResponse;
	}
	
	private PageModel getPageVideo(Map<String,Object> map, int currPage, int pageSize){
		PageModel pageModel=null;
		try{
			pageModel=new PageModel();
			List<VideoInfo> list=biz.getFreeVideos(map);

			pageModel.setCurrPage(currPage);
			pageModel.setPageSize(pageSize);
			pageModel.setList(list);
			pageModel.setTotalRecords(biz.getTotalRecords(map));
		}catch(Exception e){
			System.out.println(e);
		}
		return pageModel;
	}
	@RequestMapping("/getSum")
	@ResponseBody
	public int getI(){
		Map map=new HashMap<String, String>();
		map.put("currPage", "0");
		map.put("pageSize", "3");
		map.put("recommend", "1");
		System.out.println("@@@@@@@@@"+biz.getTotalRecords(map));
		return biz.getTotalRecords(map);
	}
}
