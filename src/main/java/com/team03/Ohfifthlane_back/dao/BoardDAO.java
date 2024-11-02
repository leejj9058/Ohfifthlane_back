package com.team03.Ohfifthlane_back.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team03.Ohfifthlane_back.vo.NoticeVO;


@Component
public class BoardDAO {
   @Autowired 
   SqlSession session;

   public List<NoticeVO> getNotice() {
      return session.selectList("getNotice");
   }

   public NoticeVO getNoticeDetail(NoticeVO vo) {
      
      return session.selectOne("getNoticeDetail", vo);
      
   }
   
   
}