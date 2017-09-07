package com.zhua.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zhua.pojo.Notice;

@Mapper
public interface NoticeMapper {

	@Select("select * from notice")
	List<Notice> findAll();

	List<Notice> findByPage(@Param("page")Integer page, @Param("rows")Integer rows);

	int count();
}
