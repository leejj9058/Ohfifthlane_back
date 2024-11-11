package com.team03.Ohfifthlane_back.vo;

public class DisabledPersonVO {

	int disablePersonId; 
	String disabledPersonCarNum;
	String disablePersonIssueDate;
	
	
	public int getDisablePersonId() {
		return disablePersonId;
	}
	public void setDisablePersonId(int disablePersonId) {
		this.disablePersonId = disablePersonId;
	}
	public String getDisablePersonCarNum() {
		return disabledPersonCarNum;
	}
	public void setDisablePersonCarNum(String disablePersonCarNum) {
		this.disabledPersonCarNum = disablePersonCarNum;
	}
	public String getDisablePersonIssueDate() {
		return disablePersonIssueDate;
	}
	public void setDisablePersonIssueDate(String disablePersonIssueDate) {
		this.disablePersonIssueDate = disablePersonIssueDate;
	}
	
	
	@Override
	public String toString() {
		return "DisabledPersonVO [disablePersonId=" + disablePersonId + ", disablePersonCarNum=" + disabledPersonCarNum
				+ ", disablePersonIssueDate=" + disablePersonIssueDate + "]";
	}
	
	
	
}
