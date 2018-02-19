package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/joinform")
	public String joinform() {

		return "user/joinform";
	}

	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo userVo) {

		if(userVo.getUserName() != null && userVo.getUserName() != "" 
				&& userVo.getUserId() != null && userVo.getUserId() != ""
				&& userVo.getPassword() != null && userVo.getPassword() != "") {
			userService.join(userVo);
			
			return "user/joinSuccess";
		} else
			return "redirect:/user/joinform";
	}

	@RequestMapping("/loginform")
	public String loginform() {

		return "user/loginForm";
	}

	@RequestMapping("/login")
	public String login(@RequestParam String id, @RequestParam String password, HttpSession session) {
		UserVo authUser = userService.login(id, password);
		session.setAttribute("authUser", authUser);
		System.out.println("Login :: " + authUser.toString());

		return "redirect:/main";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");

		return "redirect:/main";
	}

}
