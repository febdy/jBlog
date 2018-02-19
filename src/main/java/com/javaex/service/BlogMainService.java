package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogMainDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.PostVo;

@Service
public class BlogMainService {

	@Autowired
	BlogMainDao blogMainDao;

	@Autowired
	UserDao userDao;

	public List<PostVo> getPostList(String userId) {
		int userNo = userDao.getUserNoById(userId);

		return blogMainDao.getPostList(userNo);
	}
}
