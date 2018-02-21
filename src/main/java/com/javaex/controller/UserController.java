package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo userVo) {
		if (userVo.getUserName() != null && userVo.getUserName() != "" && 
			userVo.getUserId() != null && userVo.getUserId() != "" && 
			userVo.getPassword() != null && userVo.getPassword() != "") {
			
			userService.join(userVo);

			return "user/joinSuccess";
		} else
			return "user/joinform";
	}

	@RequestMapping("/login")
	public String login(@RequestParam(required=false) String id, 
						@RequestParam(required=false) String password, 
						Model model, 
						HttpSession session) {
		
		if(id == null && password == null)
			return "user/loginForm";
		
		UserVo authUser = userService.login(id, password);

		if (authUser != null) {
			session.setAttribute("authUser", authUser);
			System.out.println("Login :: " + authUser.toString());

			return "redirect:/";			
		}

		model.addAttribute("loginfail", true);

		return "redirect:/user/login";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session, @RequestParam(required=false) String userId) {
		session.removeAttribute("authUser");

		if(userId != null)
			return "redirect:/" + userId;
		
		return "redirect:/";
	}

}
