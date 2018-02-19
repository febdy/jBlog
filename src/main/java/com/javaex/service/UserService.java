package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaex.dao.BlogAdminDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private BlogAdminDao blogAdminDao;

	@Transactional
	public void join(UserVo userVo) {
		userDao.join(userVo);
		int userNo = userVo.getUserNo();

		blogAdminDao.setAdminBasic(userVo);
		blogAdminDao.setCategory(userNo);
	}

	public UserVo login(String id, String password) {
		return userDao.login(id, password);
	}

	public int checkId(String userId) {
		return userDao.checkId(userId);
	}
}
