package com.javaex.vo;

public class CommentsVo {
	private int cmtNo;
	private int postNo;
	private String cmtContent;
	private String regDate;

	public CommentsVo() {

	}

	public CommentsVo(int cmtNo, int postNo, String cmtContent, String regDate) {
		super();
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
