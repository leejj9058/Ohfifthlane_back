package com.team03.Ohfifthlane_back.vo;

public class UserVO {
	int userId;
	int userType;
	String email; // 아이디=이메일
	String password;
	String name;
	String rrnFront;
	String rrnBack;
	String nickname;
	String phoneNum;
	String address;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRrnFront() {
		return rrnFront;
	}
	public void setRrnFront(String rrnFront) {
		this.rrnFront = rrnFront;
	}
	public String getRrnBack() {
		return rrnBack;
	}
	public void setRrnBack(String rrnBack) {
		this.rrnBack = rrnBack;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userType=" + userType + ", email=" + email + ", password=" + password
				+ ", name=" + name + ", rrnFront=" + rrnFront + ", rrnBack=" + rrnBack + ", nickname=" + nickname
				+ ", phoneNum=" + phoneNum + ", address=" + address + "]";
	}
	
}
