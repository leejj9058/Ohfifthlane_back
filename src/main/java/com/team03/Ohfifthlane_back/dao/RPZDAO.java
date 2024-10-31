package com.team03.Ohfifthlane_back.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team03.Ohfifthlane_back.vo.RPZVO;
import com.team03.Ohfifthlane_back.vo.UserLocationVO;

@Component
public class RPZDAO {

	@Autowired
	SqlSession session;

	public List<RPZVO> getNearRPZList(UserLocationVO ulVO) {
		
		return session.selectList("getNearRPZList", ulVO);
	}

	
	
	
	
}
