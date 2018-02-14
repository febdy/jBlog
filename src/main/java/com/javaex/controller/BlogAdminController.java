package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BlogAdminService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/{userId}/admin")
public class BlogAdminController {
	
	@Autowired
	BlogAdminService blogAdminService;

	@RequestMapping("/basic")
	public String adminBasic(@PathVariable String userId) {

		return "blog/admin/blog-admin-basic";
	}

	@RequestMapping("/basicupdate")
	public String adminBasicUpdate(@PathVariable String userId,
								   @ModelAttribute BlogVo blogVo,
								   HttpSession session) {
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		blogVo.setUserNo(authUser.getUserNo());
		blogVo.setLogoFile("");
		
		blogAdminService.adminBasicUpdate(blogVo);
		
		return "redirect:/blog/admin/basic";
	}
	
	@RequestMapping("/category")
	public String adminCategory(@PathVariable String userId) {

		return "blog/admin/blog-admin-cate";
	}
	
	@RequestMapping("/write")
	public String adminWrite(@PathVariable String userId) {

		return "blog/admin/blog-admin-write";
	}
	
}
