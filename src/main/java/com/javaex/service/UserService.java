package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public void join(UserVo userVo) {
		userDao.join(userVo);
	}

	public UserVo login(String id, String password) {
		return userDao.login(id, password);
	}
}
