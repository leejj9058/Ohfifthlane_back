package com.team03.Ohfifthlane_back.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team03.Ohfifthlane_back.vo.ReportVO;

@Component
public class ReportDAO {

	@Autowired
	SqlSession session;

	public void createReport(ReportVO reportVO) {
		
		session.insert("createReport", reportVO);
	}

	public List<ReportVO> getReportList() {

		return session.selectList("getReportList");
	}

	public ReportVO getReportByReportId(int reportId) {
		
		return session.selectOne("getReportByReportId", reportId);
	}

	public void updateReportStatus(ReportVO reportVO) {
		
		session.update("updateReportStatus", reportVO);
	}

	
	
}
