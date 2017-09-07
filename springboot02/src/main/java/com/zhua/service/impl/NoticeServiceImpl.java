package com.zhua.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhua.mapper.NoticeMapper;
import com.zhua.pojo.Notice;
import com.zhua.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeMapper noticeMapper;

	@Override
	public List<Notice> findAll() {
		return noticeMapper.findAll();
	}

	/**
	 * 分页
	 */
	@Override
	public Map<String,Object> findByPage(Integer page, Integer rows) {
		Map<String, Object> hm = new HashMap<String, Object>();
		
		List<Notice> list = noticeMapper.findByPage(page,rows);
		int count = noticeMapper.count();
		hm.put("rows", list);
		hm.put("total", count);
		return hm;
	}

}
