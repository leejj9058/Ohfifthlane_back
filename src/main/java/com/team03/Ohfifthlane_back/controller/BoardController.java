package com.team03.Ohfifthlane_back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team03.Ohfifthlane_back.dao.BoardDAO;
import com.team03.Ohfifthlane_back.vo.InquiryVO;
import com.team03.Ohfifthlane_back.vo.NoticeVO;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api")
public class BoardController {
   
   @Autowired BoardDAO dao;
   
   //공지사항 가져오기
   @PostMapping("/getNotice")
   public ResponseEntity<?> getNotice() {
      System.out.println("요청됨");
      List<NoticeVO> notices = dao.getNotice();
      System.out.println(notices);
      return ResponseEntity.ok(notices);
   }
   
   
   //공지사항 상세
   @PostMapping("/getNoticeDetail")
   public ResponseEntity<?> getNoticeDetail(@RequestBody NoticeVO vo) {
      System.out.println("요청됨");
      NoticeVO notice = dao.getNoticeDetail(vo);
      System.out.println(notice);
      return ResponseEntity.ok(notice);
   }
   
   
   //문의사항 가져오기
   @PostMapping("/getInquiry")
   public ResponseEntity<?> getInquiry() {
	   System.out.println("문의사항요청됨");
	   List<InquiryVO> Inquiries = dao.getInquiry();
	   System.out.println(Inquiries);
	   return ResponseEntity.ok(Inquiries);
	   
   }
   
   
   //문의사항 상세
   @PostMapping("/getInquiryDetail")
   public ResponseEntity<?> getInquiryDetail(@RequestBody InquiryVO vo) {
      System.out.println("디테일 요청됨");
      InquiryVO inquiry = dao.getInquiryDetail(vo);
      System.out.println(inquiry);
      return ResponseEntity.ok(inquiry);
   }
   
   
   //공지사항 작성
   @PostMapping("/writeNotice")
   public ResponseEntity<?> writeNotice(@RequestBody NoticeVO vo) {
	   System.out.println("공지사항 작성 요청됨");
	   int result = dao.insertNotice(vo);
	   System.out.println("작성결과 : " + result);
	   return ResponseEntity.ok(result);
   }
   
   
   //문의사항 작성
   @PostMapping("/writeInquiry")
   public ResponseEntity<?> writeInquiry(@RequestBody InquiryVO vo) {
	   System.out.println("문의사항 작성 요청됨");
	   int result = dao.insertInquiry(vo);
	   System.out.println("작성결과 : " + result);
	   return ResponseEntity.ok(result);
   }
   
   
   //공지사항 게시글 삭제
   @DeleteMapping("/deleteNotice/{noticeId}")
   public ResponseEntity<?> deleteNotice(@PathVariable int noticeId) {
       System.out.println("공지사항 삭제 요청됨, ID: " + noticeId);
       int result = dao.deleteNotice(noticeId);
       
       if (result > 0) {
           System.out.println("삭제 결과: " + result);
           return ResponseEntity.ok("삭제 성공");
       } else {
           System.out.println("삭제 실패: 해당 ID의 공지사항이 존재하지 않음");
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("삭제 실패: 해당 ID의 공지사항이 존재하지 않음");
       }
   }
   
   
   
   

   
   
   
}