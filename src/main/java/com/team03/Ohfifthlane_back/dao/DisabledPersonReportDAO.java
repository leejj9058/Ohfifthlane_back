package com.team03.Ohfifthlane_back.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team03.Ohfifthlane_back.vo.DisabledPersonReportVO;

@Component
public class DisabledPersonReportDAO {

	@Autowired
	SqlSession session;

	public void createDisabledPersonReport(DisabledPersonReportVO dprVO) {

		session.insert("createDisabledPersonReport", dprVO);
	}

	public List<DisabledPersonReportVO> getDisabledPersonReportList() {

		return session.selectList("getDisabledPersonReportList");
	}

	public DisabledPersonReportVO getDisabledPersonReportByDprId(int disabledPersonReportId) {

		return session.selectOne("getDisabledPersonReportByDprId", disabledPersonReportId);
	}

	public void updateDisabledPersonReportStatus(DisabledPersonReportVO dprVO) {

		session.update("updateDisabledPersonReportStatus", dprVO);
	}
	
	
	
}
