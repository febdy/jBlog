package com.javaex.vo;

public class CommentVo {
	private int cmtNo;
	private int postNo;
	private String userNo;
	private String userId;
	private String cmtContent;
	private String regDate;

	public CommentVo() {

	}

	public CommentVo(int cmtNo, int postNo, String cmtContent, String regDate) {
		this.cmtNo = cmtNo;
		this.postNo = postNo;
		this.cmtContent = cmtContent;
		this.regDate = regDate;
	}

	public int getCmtNo() {
		return cmtNo;
	}

	public void setCmtNo(int cmtNo) {
		this.cmtNo = cmtNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getCmtContent() {
		return cmtContent;
	}

	public void setCmtContent(String cmtContent) {
		this.cmtContent = cmtContent;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "CommentsVo [cmtNo=" + cmtNo + ", postNo=" + postNo + ", cmtContent=" + cmtContent + ", regDate="
				+ regDate + "]";
	}

}
