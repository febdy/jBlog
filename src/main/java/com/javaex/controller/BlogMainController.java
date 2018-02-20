package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BlogMainService;
import com.javaex.vo.CategoryVo;

@Controller
public class BlogMainController {

	@Autowired
	BlogMainService blogMainservice;

	@RequestMapping("/{userId}")
	public String blogMain(@PathVariable String userId, Model model) {

		String logoUrl = blogMainservice.getLogo(userId);
		model.addAttribute("logoUrl", logoUrl);

		List<CategoryVo> cList = blogMainservice.getCategoryList(userId);
		model.addAttribute("cList", cList);

		return "blog/blog-main";
	}

}
