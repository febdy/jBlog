package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogPostDao;
import com.javaex.vo.CommentVo;

@Service
public class BlogPostService {

	@Autowired
	BlogPostDao blogPostDao;

	public List<CommentVo> getCommentList(int postNo) {
		return blogPostDao.getCommentList(postNo);
	}

	public void addComment(CommentVo cmtVo) {
		blogPostDao.addComment(cmtVo);
	}
}
