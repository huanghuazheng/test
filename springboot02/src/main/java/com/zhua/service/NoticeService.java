package com.zhua.service;

import java.util.List;
import java.util.Map;

import com.zhua.pojo.Notice;

public interface NoticeService {

	public List<Notice> findAll();

	public Map<String,Object> findByPage(Integer page, Integer rows);

}
