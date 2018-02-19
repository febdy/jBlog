package com.javaex.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;

@Controller
@RequestMapping("/api/users")
public class ApiUserController {

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping("/checkId")
	public int checkId(@RequestParam String userId) {

		return userService.checkId(userId);
	}
}
