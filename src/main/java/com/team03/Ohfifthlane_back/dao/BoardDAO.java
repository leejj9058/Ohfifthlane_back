package com.team03.Ohfifthlane_back.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team03.Ohfifthlane_back.vo.InquiryVO;
import com.team03.Ohfifthlane_back.vo.NoticeVO;


@Component
public class BoardDAO {
   @Autowired 
   SqlSession session;

   //공지사항 리스트
   public List<NoticeVO> getNotice() {
      return session.selectList("getNotice");
   }

   //공지사항 디테일
   public NoticeVO getNoticeDetail(NoticeVO vo) {
      return session.selectOne("getNoticeDetail", vo); 
   }
   
   //문의사항 리스트  
   public List<InquiryVO> getInquiry() {
	      return session.selectList("getInquiry");
   }
   
   //문의사항 디테일
   public InquiryVO getInquiryDetail(InquiryVO vo) {
	      return session.selectOne("getInquiryDetail", vo);
   }

   
   //공지사항 글쓰기
   public int insertNotice(NoticeVO vo) {
	   return session.insert("insertNotice", vo);
   }
   
   //문의사항 글쓰기
   public int insertInquiry(InquiryVO vo) {
	   return session.insert("insertInquiry", vo);
   }
   
   
   //공지사항 삭제
   public int deleteNotice(int noticeId) {
	   return session.delete("deleteNotice", noticeId);
   }
   
   
}