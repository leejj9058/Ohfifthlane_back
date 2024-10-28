package com.team03.Ohfifthlane_back.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team03.Ohfifthlane_back.vo.AccountVO;
import com.team03.Ohfifthlane_back.vo.UserVO;

@Component
public class UserDAO {
	@Autowired 
	SqlSession session;
	
	public AccountVO userLogin(AccountVO vo) {
		
		return session.selectOne("getUserByIdAndPassword", vo);
	}

	public String userFindId(UserVO uvo) {
		
		return session.selectOne("getUserEmailByNameAndUserSSNFront", uvo);
	}
}
