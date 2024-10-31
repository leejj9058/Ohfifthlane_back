package com.team03.Ohfifthlane_back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team03.Ohfifthlane_back.dao.BoardDAO;
import com.team03.Ohfifthlane_back.vo.NoticeVO;


@RestController
@RequestMapping("/api")
public class BoardController {
   
   @Autowired BoardDAO dao;
   
   @PostMapping("/getNotice")
   public ResponseEntity<?> getNotice() {
      System.out.println("요청됨");
      List<NoticeVO> notices = dao.getNotice();
      System.out.println(notices);
      return ResponseEntity.ok(notices);
   }
   
   @PostMapping("/getNoticeDetail")
   public ResponseEntity<?> getNoticeDetail(@RequestBody NoticeVO vo) {
      System.out.println("요청됨");
      NoticeVO notice = dao.getNoticeDetail(vo);
      System.out.println(notice);
      return ResponseEntity.ok(notice);
   }
   

   
   
   
}