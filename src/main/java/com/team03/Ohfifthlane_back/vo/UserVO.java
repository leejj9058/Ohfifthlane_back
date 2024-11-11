package com.team03.Ohfifthlane_back.vo;

public class UserVO {
	
	private int userId;
	private String userName;
	private String userSSNFront;
	private String userSSNBack;
	private String userTel;
	private String userAddress;
	private int accountId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSSNFront() {
		return userSSNFront;
	}
	public void setUserSSNFront(String userSSNFront) {
		this.userSSNFront = userSSNFront;
	}
	public String getUserSSNBack() {
		return userSSNBack;
	}
	public void setUserSSNBack(String userSSNBack) {
		this.userSSNBack = userSSNBack;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userName=" + userName + ", userSSNFront=" + userSSNFront
				+ ", userSSNBack=" + userSSNBack + ", userTel=" + userTel + ", userAddress=" + userAddress
				+ ", accountId=" + accountId + "]";
	}
	
	
	
	
	
	
	

}
