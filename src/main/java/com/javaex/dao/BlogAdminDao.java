package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;

@Repository
public class BlogAdminDao {

	@Autowired
	SqlSession sqlSession;

	public void setAdminBasic(int userNo) {
		sqlSession.insert("blog-admin.set_basic", userNo);
	}
	
	public BlogVo getAdminBasic(int userNo) {
		return sqlSession.selectOne("blog-admin.get_basic", userNo);
	}
	
	public void adminBasicUpdate(BlogVo blogVo) {
		sqlSession.update("blog-admin.basic_update", blogVo);
	}
	
	public void setCategory(int userNo) {
		sqlSession.insert("blog-admin.set_category", userNo);
	}

	public List<CategoryVo> getCateList(int userNo) {
		return sqlSession.selectList("blog-admin.get_cateList", userNo);
	}
}
