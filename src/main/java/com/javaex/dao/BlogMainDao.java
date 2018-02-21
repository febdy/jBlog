package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlogMainDao {

	@Autowired
	SqlSession sqlSession;

	public String getTitle(int userNo) {
		return sqlSession.selectOne("blog-main.getTitle", userNo);
	}

}
