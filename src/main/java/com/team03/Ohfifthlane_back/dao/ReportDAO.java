package com.team03.Ohfifthlane_back.dao;

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
	
}
