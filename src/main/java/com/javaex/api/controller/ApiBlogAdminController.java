package com.javaex.api.controller;

import java.util.List;
import java.util.Map;

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
import com.javaex.vo.PostVo;

@Controller
@RequestMapping("/{userId}/api/admin")
public class ApiBlogAdminController {

	@Autowired
	BlogAdminService blogAdminService;

	@ResponseBody
	@RequestMapping(value = "/getCategory", method = RequestMethod.POST)
	public List<CategoryVo> apiGetCateList(@PathVariable String userId, @RequestParam int userNo) {

		return blogAdminService.getCateList(userNo);
	}

	@ResponseBody
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public Map<String, Object> apiAddCategory(@PathVariable String userId, @RequestBody CategoryVo categoryVo) {

		return blogAdminService.addCategory(categoryVo);
	}

	@ResponseBody
	@RequestMapping(value = "/deleteCategory", method = RequestMethod.POST)
	public int apiDeleteCategory(@PathVariable String userId, @RequestParam int cateNo) {

		return blogAdminService.deleteCategory(cateNo);
	}

}
