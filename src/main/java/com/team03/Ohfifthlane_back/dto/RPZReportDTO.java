package com.team03.Ohfifthlane_back.dto;

import com.team03.Ohfifthlane_back.vo.RPZVO;
import com.team03.Ohfifthlane_back.vo.ReportVO;
import com.team03.Ohfifthlane_back.vo.UserVO;

public class RPZReportDTO {

	private RPZVO rpz;
	private ReportVO report;
	private UserVO user;
	
	
	public UserVO getUser() {
		return user;
	}
	public void setUser(UserVO user) {
		this.user = user;
	}
	public RPZVO getRpz() {
		return rpz;
	}
	public void setRpz(RPZVO rpz) {
		this.rpz = rpz;
	}
	public ReportVO getReport() {
		return report;
	}
	public void setReport(ReportVO report) {
		this.report = report;
	}
	
	@Override
	public String toString() {
		return "RPZReportDTO [rpz=" + rpz + ", report=" + report + ", user=" + user + "]";
	}
	
}
