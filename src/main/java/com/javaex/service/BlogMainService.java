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
