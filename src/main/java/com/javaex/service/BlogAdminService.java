package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogAdminDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;

@Service
public class BlogAdminService {

	@Autowired
	BlogAdminDao blogAdminDao;

	public BlogVo getAdminBasic(int userNo) {
		return blogAdminDao.getAdminBasic(userNo);
	}

	public void adminBasicUpdate(BlogVo blogVo, MultipartFile logoFile) {

		if (!logoFile.isEmpty()) {
			String saveDir = "D:\\javaStudy\\upload";
			String orgName = logoFile.getOriginalFilename(); // 원래 파일 이름
			String exName = orgName.substring(orgName.lastIndexOf(".")); // 확장자
			String saveName = UUID.randomUUID().toString() + exName; // 지정한 파일 이름
			// String filePath = saveDir + "\\" + saveName; // 파일위치(패스)

			// 파일 카피
			try {
				byte[] fileData = logoFile.getBytes();
				OutputStream out = new FileOutputStream(saveDir + "/" + saveName);
				BufferedOutputStream bos = new BufferedOutputStream(out);
				bos.write(fileData);

				if (bos != null) {
					bos.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

			blogVo.setLogoFile(saveName);
		}

		blogAdminDao.adminBasicUpdate(blogVo);
	}

	public List<CategoryVo> getCateList(int userNo) {
		return blogAdminDao.getCateList(userNo);
	}

	public void addCategory(CategoryVo categoryVo) {
		blogAdminDao.addCategory(categoryVo);
		categoryVo.setCateNo(blogAdminDao.getCateCnt(categoryVo.getUserNo()));
	}
}
