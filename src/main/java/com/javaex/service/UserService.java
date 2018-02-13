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
<<<<<<< HEAD

	public UserVo login(String id, String password) {
		return userDao.login(id, password);
	}
=======
>>>>>>> 8a3360a9c7f5d24f2163034f0dfcfd97fa13969d
}
