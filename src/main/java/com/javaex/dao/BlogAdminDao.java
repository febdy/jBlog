package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;


@Repository
public class BlogAdminDao {

	@Autowired
	SqlSession sqlSession;

	// ADMIN BASIC
	public void setAdminBasic(int userNo) {
		sqlSession.insert("blog-admin.setBasic", userNo);
	}

	public BlogVo getAdminBasic(int userNo) {
		return sqlSession.selectOne("blog-admin.getBasic", userNo);
	}

	public void adminBasicUpdate(BlogVo blogVo) {
		sqlSession.update("blog-admin.basicUpdate", blogVo);
	}

	// CATEGORY
	public void setCategory(int userNo) {
		sqlSession.insert("blog-admin.setCategory", userNo);
	}

	public List<CategoryVo> getCateList(int userNo) {
		return sqlSession.selectList("blog-admin.getCateList", userNo);
	}

	public void addCategory(CategoryVo categoryVo) {
		sqlSession.insert("blog-admin.addCategory", categoryVo);
	}

	public int getCateCnt(int userNo) {
		return sqlSession.selectOne("blog-admin.getCateCnt", userNo);
	}

	public int deleteCategory(int cateNo) {
		return sqlSession.delete("blog-admin.deleteCategory", cateNo);
	}

	public void write(PostVo postVo) {
		sqlSession.insert("blog-admin.write", postVo);
	}

	public void addCategory(CategoryVo categoryVo) {
		sqlSession.insert("blog-admin.addCategory", categoryVo);
	}

	public int getCateCnt(int userNo) {
		return sqlSession.selectOne("blog-admin.getCateCnt", userNo);
	}

	public int deleteCategory(int cateNo) {
		return sqlSession.delete("blog-admin.deleteCategory", cateNo);
	}
}
