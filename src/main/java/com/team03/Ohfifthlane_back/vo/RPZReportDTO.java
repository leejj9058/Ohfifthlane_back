package com.team03.Ohfifthlane_back.vo;

public class RPZReportDTO {

	private RPZVO rpz;
	private ReportVO report;
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
		return "RPZReportDTO [rpz=" + rpz + ", report=" + report + "]";
	}
	
	
	
}
