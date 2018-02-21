package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogPostDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.CommentVo;
import com.javaex.vo.PostVo;

@Service
public class BlogPostService {

	@Autowired
	UserDao userDao;

	@Autowired
	BlogPostDao blogPostDao;

	public List<PostVo> getPostList(String userId, int cateNo) {
		int userNo = userDao.getUserNoById(userId);

		if (cateNo == 0)
			return blogPostDao.getPostList(userNo);
		else
			return blogPostDao.getPostList(userNo, cateNo);
	}

	public PostVo getPost(int postNo) {
		PostVo postVo = blogPostDao.getPost(postNo);

		return postVo;
	}

	public List<CommentVo> getCommentList(int postNo) {
		return blogPostDao.getCommentList(postNo);
	}

	public void addComment(CommentVo cmtVo) {
		blogPostDao.addComment(cmtVo);
	}
}
