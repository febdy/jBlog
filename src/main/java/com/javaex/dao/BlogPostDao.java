package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CommentVo;
import com.javaex.vo.PostVo;

@Repository
public class BlogPostDao {

	@Autowired
	SqlSession sqlSession;

	public List<PostVo> getPostList(int userNo) {
		return sqlSession.selectList("blog-post.getAllPostList", userNo);
	}

	public List<PostVo> getPostList(int userNo, int cateNo) { // get post list by category
		Map<String, Integer> map = new HashMap<>();
		map.put("userNo", userNo);
		map.put("cateNo", cateNo);

		return sqlSession.selectList("blog-post.getPostListByCate", map);
	}

	public PostVo getPost(int postNo) {
		return sqlSession.selectOne("blog-post.getPost", postNo);
	}

	public int getPostCnt(int cateNo) {
		return sqlSession.selectOne("blog-post.getPostCnt", cateNo);
	}

	public List<CommentVo> getCommentList(int postNo) {
		return sqlSession.selectList("blog-post.getCommentList", postNo);
	}

	public void addComment(CommentVo cmtVo) {
		sqlSession.insert("blog-post.addComment", cmtVo);
	}

	public CommentVo getComment(int cmtNo) {
		return sqlSession.selectOne("blog-post.getComment", cmtNo);
	}

	public int removeComment(int cmtNo) {
		return sqlSession.delete("blog-post.removeComment", cmtNo);
	}
}
