package com.javaex.dao;

<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;

=======
>>>>>>> 8a3360a9c7f5d24f2163034f0dfcfd97fa13969d
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	SqlSession sqlSession;

	public void join(UserVo userVo) {
		sqlSession.insert("users.join", userVo);
	}

<<<<<<< HEAD
	public UserVo login(String id, String password) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("password", password);

		return sqlSession.selectOne("users.login", map);
	}

=======
>>>>>>> 8a3360a9c7f5d24f2163034f0dfcfd97fa13969d
}
