package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogAdminDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogAdminService {

	@Autowired
	BlogAdminDao blogAdminDao;

	public void adminBasicUpdate(BlogVo blogVo) {
		blogAdminDao.adminBasicUpdate(blogVo);
	}
}
