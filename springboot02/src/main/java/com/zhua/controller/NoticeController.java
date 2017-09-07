package com.zhua.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhua.pojo.Notice;
import com.zhua.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("/getNotice")
	public String getNotice(Model model){
		model.addAttribute("itemArr", new String[]{"优酸乳","蒙牛","伊利"});
		
		return "item";
	}
	
	/**
	 * @描述  查询所有
	 */
	@ResponseBody
	@RequestMapping("/findAll")
	public List<Notice> findAll(){
		List<Notice> findAll = noticeService.findAll();
		return findAll;
	}
	
	@GetMapping("/show")
	public String show(){
		return "/html/notice.html";
	}
	
	@ResponseBody
	@RequestMapping("/findByPage")
	public Map<String,Object> findByPage(@RequestParam(value="page",defaultValue="1",required=false)Integer page,
			@RequestParam(value="rows",defaultValue="10",required=false)Integer rows){
		
		return noticeService.findByPage((page-1)*rows,rows);
	}
	
}
