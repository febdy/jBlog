package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {

	@RequestMapping("/{userId}")
	public String blog(@PathVariable String userId) {

		return "blog/blog-main";
	}
}
