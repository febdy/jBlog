package com.javaex.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;

	public void join(UserVo userVo) {
		sqlSession.insert("users.join", userVo);
	}

	public UserVo login(String id, String password) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("password", password);

		return sqlSession.selectOne("users.login", map);
	}

	public int checkId(String userId) {
		return sqlSession.selectOne("users.checkId", userId);
	}

}
