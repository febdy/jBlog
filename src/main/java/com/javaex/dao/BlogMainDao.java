package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PostVo;

@Repository
public class BlogMainDao {

	@Autowired
	SqlSession sqlSession;

	public List<PostVo> getPostList(int userNo) {
		return sqlSession.selectList("blog-main.getPostList", userNo);
	}
}
