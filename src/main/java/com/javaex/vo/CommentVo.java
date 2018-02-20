package com.javaex.vo;

public class CommentVo {
	private int cmtNo;
	private int postNo;
	private String cmtName;
	private String cmtContent;
	private String regDate;

	public CommentVo() {

	}

	public CommentVo(int cmtNo, int postNo, String cmtContent, String regDate) {
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

	public String getCmtName() {
		return cmtName;
	}

	public void setCmtname(String cmtName) {
		this.cmtName = cmtName;
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
