package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.BlogMainService;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;

@Controller
@RequestMapping("/{userId}/api")
public class ApiBlogMainController {

	@Autowired
	BlogMainService blogMainService;

	@ResponseBody
	@RequestMapping("/getPostList")
	public List<PostVo> apiGetPostList(@PathVariable String userId, @RequestParam int cateNo) {

		return blogMainService.getPostList(userId, cateNo);
	}

	@ResponseBody
	@RequestMapping("/getCateList")
	public List<CategoryVo> apiGetCategoryList(@PathVariable String userId) {

		return blogMainService.getCategoryList(userId);
	}

	@ResponseBody
	@RequestMapping("/getLogo")
	public String apiGetLogoFile(@PathVariable String userId) {

		return blogMainService.getLogo(userId);
	}

	@ResponseBody
	@RequestMapping("/getTitle")
	public String apiGetTitle(@PathVariable String userId) {
		
		return blogMainService.getTitle(userId);
	}

}
