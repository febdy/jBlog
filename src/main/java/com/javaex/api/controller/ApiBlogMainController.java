package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.BlogMainService;
import com.javaex.service.BlogPostService;
import com.javaex.vo.CommentVo;
import com.javaex.vo.PostVo;

@Controller
@RequestMapping("/{userId}/api")
public class ApiBlogMainController {

	@Autowired
	BlogMainService blogMainService;

	@Autowired
	BlogPostService blogPostService;

	@ResponseBody
	@RequestMapping("/getPostList")
	public List<PostVo> apiGetPostList(@PathVariable String userId, @RequestParam int cateNo) {

		return blogPostService.getPostList(userId, cateNo);
	}

	@ResponseBody
	@RequestMapping("/getPost")
	public PostVo apiGetPost(@PathVariable String userId, @RequestParam int postNo) {

		return blogPostService.getPost(postNo);
	}

	@ResponseBody
	@RequestMapping("/getTitle")
	public String apiGetTitle(@PathVariable String userId) {

		return blogMainService.getTitle(userId);
	}

	@ResponseBody
	@RequestMapping("/getCommentList")
	public List<CommentVo> apiGetCommentList(@PathVariable String userId, @RequestParam int postNo) {

		return blogPostService.getCommentList(postNo);
	}

	@ResponseBody
	@RequestMapping("/addComment")
	public CommentVo apiAddComment(@PathVariable String userId, 
								  @RequestParam int postNo,
								  @RequestParam String cmtUserNo,
								  @RequestParam String cmtContent) {

		CommentVo cmtVo = new CommentVo();
		cmtVo.setPostNo(postNo);
		cmtVo.setUserNo(cmtUserNo);
		cmtVo.setCmtContent(cmtContent);

		return blogPostService.addComment(cmtVo);
	}
}
