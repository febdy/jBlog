package com.javaex.controller;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogAdminService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/{userId}/admin")
public class BlogAdminController {
	
	@Autowired
	BlogAdminService blogAdminService;

	@RequestMapping("/basic")
	public String adminBasic(@PathVariable String userId, HttpSession session, Model model) {
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		BlogVo blogVo = blogAdminService.getAdminBasic(authUser.getUserNo());
		model.addAttribute("blogVo", blogVo);

		return "blog/admin/blog-admin-basic";
	}

	@RequestMapping("/basicupdate")
	public String adminBasicUpdate(@PathVariable String userId,
								   @RequestParam("title") String blogTitle,
								   @RequestParam(value="logo-file", required=false) MultipartFile logoFile,
								   HttpSession session) {

		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		BlogVo blogVo = new BlogVo();
		blogVo.setUserNo(authUser.getUserNo());
		blogVo.setBlogTitle(blogTitle);
		
		blogAdminService.adminBasicUpdate(blogVo, logoFile);
		
		return "redirect:/" + userId + "/admin/basic";
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
