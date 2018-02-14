package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogAdminDao {

	@Autowired
	SqlSession sqlSession;

	public void adminBasicUpdate(BlogVo blogVo) {
		sqlSession.update("blog-admin.basic_update", blogVo);
	}

}
