package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CommentVo;

@Repository
public class BlogPostDao {

	@Autowired
	SqlSession sqlSession;

	public List<CommentVo> getCommentList(int postNo) {
		return sqlSession.selectList("blog-post.getCommentList", postNo);
	}

	public void addComment(CommentVo cmtVo) {
		sqlSession.insert("blog-post.addComment", cmtVo);
	}
}
