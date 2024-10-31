package com.team03.Ohfifthlane_back.vo;

public class NoticeVO {
   
   int noticeId ;
   String noticeTitle;
   String noticeContent;
   String noticeDate;
   int userId;
   
   
   public int getNoticeId() {
      return noticeId;
   }
   public void setNoticeId(int noticeId) {
      this.noticeId = noticeId;
   }
   public String getNoticeTitle() {
      return noticeTitle;
   }
   public void setNoticeTitle(String noticeTitle) {
      this.noticeTitle = noticeTitle;
   }
   public String getNoticeContent() {
      return noticeContent;
   }
   public void setNoticeContent(String noticeContent) {
      this.noticeContent = noticeContent;
   }
   public String getNoticeDate() {
      return noticeDate;
   }
   public void setNoticeDate(String noticeDate) {
      this.noticeDate = noticeDate;
   }
   public int getUserId() {
      return userId;
   }
   public void setUserId(int userId) {
      this.userId = userId;
   }
   
   @Override
   public String toString() {
      return "NoticeVO [noticeId=" + noticeId + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
            + ", noticeDate=" + noticeDate + ", userId=" + userId + "]";
   }
   
   

}