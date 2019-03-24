/*
package com.zsc.edu.controller;

import com.zsc.edu.entity.ChapterDetailed;
import com.zsc.edu.service.TestBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test {
	
	@Autowired
	TestBiz biz;
	
	@RequestMapping("/play")
	public ModelAndView play(@RequestParam("detailedId")int detailedId){
		ModelAndView modelAndView=new ModelAndView("index4");
		ChapterDetailed testD=biz.getChapterDetailed(detailedId);
		modelAndView.addObject("video",testD);
		return modelAndView;
	}
}
*/
