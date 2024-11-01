package com.team03.Ohfifthlane_back.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team03.Ohfifthlane_back.vo.DisabledPersonVO;

@Component
public class QRDAO {

	@Autowired
	SqlSession session;

	public Boolean checkVehicle(DisabledPersonVO vo) {
		
		 int result = session.selectOne("checkVehicle", vo);
		 System.out.println(result);
		 if(result != 0) {
			 return true;
		 }else {
			 return false;			 
		 }
		
	}



	
	
	
	
}
