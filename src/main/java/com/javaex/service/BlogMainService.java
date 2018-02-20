package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogAdminDao;
import com.javaex.dao.BlogMainDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;

@Service
public class BlogMainService {

	@Autowired
	BlogMainDao blogMainDao;

	@Autowired
	UserDao userDao;

	@Autowired
	BlogAdminDao blogAdminDao;

	public List<PostVo> getPostList(String userId, int cateNo) {
		int userNo = userDao.getUserNoById(userId);

		if (cateNo == 0)
			return blogMainDao.getPostList(userNo);
		else
			return blogMainDao.getPostList(userNo, cateNo);
	}

	public PostVo getPost(int postNo) {
		PostVo postVo = blogMainDao.getPost(postNo);
		
		return postVo;
	}

	public List<CategoryVo> getCategoryList(String userId) {
		int userNo = userDao.getUserNoById(userId);

		return blogAdminDao.getCateList(userNo);
	}

	public String getLogo(String userId) {
		int userNo = userDao.getUserNoById(userId);

		String logoUrl = blogAdminDao.getAdminBasic(userNo).getLogoFile();

		if (logoUrl != null)
			logoUrl = "/upload/" + logoUrl;
		else
			logoUrl = "/assets/images/spring-logo.jpg";

		return logoUrl;
	}

	public String getTitle(String userId) {
		int userNo = userDao.getUserNoById(userId);

		return blogMainDao.getTitle(userNo);
	}

}
