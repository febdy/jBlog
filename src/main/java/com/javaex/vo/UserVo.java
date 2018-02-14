package com.javaex.vo;

public class UserVo {

	private int userNo;
	private String userId;
	private String userName;
	private String password;
	private String joinDate;

	public UserVo() {

	}

	public UserVo(int userNo, String userId, String userName, String password, String joinDate) {
		this.userNo = userNo;
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.joinDate = joinDate;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "UserVo [userNo=" + userNo + ", userId=" + userId + ", userName=" + userName + ", password=" + password
				+ ", joinDate=" + joinDate + "]";
	}

}
