package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PostVo;

@Repository
public class BlogMainDao {

	@Autowired
	SqlSession sqlSession;

	public List<PostVo> getPostList(int userNo) {
		return sqlSession.selectList("blog-main.getAllPostList", userNo);
	}

	public List<PostVo> getPostList(int userNo, int cateNo) {
		Map<String, Integer> map = new HashMap<>();
		map.put("userNo", userNo);
		map.put("cateNo", cateNo);

		return sqlSession.selectList("blog-main.getPostListByCate", map);
	}

	public String getTitle(int userNo) {
		return sqlSession.selectOne("blog-main.getTitle", userNo);
	}
}
