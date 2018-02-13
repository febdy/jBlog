package com.javaex.controller;

<<<<<<< HEAD
import javax.servlet.http.HttpSession;

=======
>>>>>>> 8a3360a9c7f5d24f2163034f0dfcfd97fa13969d
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestParam;
=======
>>>>>>> 8a3360a9c7f5d24f2163034f0dfcfd97fa13969d

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/joinform")
	public String joinform() {

		return "user/joinform";
	}

	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo userVo) {
		userService.join(userVo);

		return "user/joinSuccess";
	}
<<<<<<< HEAD

	@RequestMapping("/loginform")
	public String loginform() {

		return "user/loginForm";
	}

	@RequestMapping("/login")
	public String login(@RequestParam String id, @RequestParam String password, HttpSession session) {
		UserVo authUser = userService.login(id, password);
		session.setAttribute("authUser", authUser);

		return "redirect:/main";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");

		return "redirect:/main";
	}
=======
	
>>>>>>> 8a3360a9c7f5d24f2163034f0dfcfd97fa13969d
}
