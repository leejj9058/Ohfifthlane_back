package com.team03.Ohfifthlane_back.vo;

public class AccountVO {
	int accountId;
	String accountEmail;
	String accountPassword;
	int accountLevel; // 회원 등급
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountEmail() {
		return accountEmail;
	}
	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}
	public String getAccountPassword() {
		return accountPassword;
	}
	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
	public int getAccountLevel() {
		return accountLevel;
	}
	public void setAccountLevel(int accountLevel) {
		this.accountLevel = accountLevel;
	}
	@Override
	public String toString() {
		return "AccountVO [accountId=" + accountId + ", accountEmail=" + accountEmail + ", accountPassword="
				+ accountPassword + ", accountLevel=" + accountLevel + "]";
	}
	
}
