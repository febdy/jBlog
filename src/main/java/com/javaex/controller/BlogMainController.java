package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogMainController {

	@RequestMapping("/{userId}")
	public String blogMain(@PathVariable String userId) {

		return "blog/blog-main";
	}

}
