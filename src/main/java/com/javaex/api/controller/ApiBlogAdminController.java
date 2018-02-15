package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.BlogAdminService;
import com.javaex.vo.CategoryVo;

@Controller
@RequestMapping("/{userId}/api/admin")
public class ApiBlogAdminController {

	@Autowired
	BlogAdminService blogAdminService;

	@ResponseBody
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public List<CategoryVo> apiCateList(@PathVariable String userId, @RequestParam int userNo) {

		return blogAdminService.getCateList(userNo);
	}

	@ResponseBody
	@RequestMapping(value = "/categoryAdd", method = RequestMethod.POST)
	public CategoryVo apiCateAdd(@PathVariable String userId, @RequestBody CategoryVo categoryVo) {
		blogAdminService.addCategory(categoryVo);

		return categoryVo;
	}

}
