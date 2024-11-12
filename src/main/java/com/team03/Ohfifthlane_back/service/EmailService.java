package com.team03.Ohfifthlane_back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender; // 주입 필드

    private static final String senderEmail = "lkk030400@gmail.com"; // 실제 이메일 주소 입력
    private static int number;  // 랜덤 인증 코드

    @Autowired
    public EmailService(JavaMailSender javaMailSender) { // 생성자를 통한 주입
        this.javaMailSender = javaMailSender;
    }

    // 랜덤 인증 코드 생성
    public static void createNumber() {
        number = (int)(Math.random() * 90000) + 100000;
    }

    // 메일 양식 작성
    public MimeMessage createMail(String mail) {
        createNumber();  // 인증 코드 생성
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            message.setFrom(senderEmail);   // 보내는 이메일
            message.setRecipients(MimeMessage.RecipientType.TO, mail); // 수신자 이메일
            message.setSubject("[WalkingMate] 회원가입을 위한 이메일 인증");  // 제목 설정

            String body = "<h1>안녕하세요.</h1>";
            body += "<h1>오차로 입니다.</h1>";
            body += "<h3>회원가입을 위한 요청하신 인증 번호입니다.</h3><br>";
            body += "<h2>아래 코드를 회원가입 창으로 돌아가 입력해주세요.</h2>";
            body += "<div align='center' style='border:1px solid black; font-family:verdana;'>";
            body += "<h2>회원가입 인증 코드입니다.</h2>";
            body += "<h1 style='color:blue'>" + number + "</h1>";
            body += "</div><br>";
            body += "<h3>감사합니다.</h3>";

            message.setText(body, "UTF-8", "html");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return message;
    }

    // 실제 메일 전송
    public int sendEmail(String accountEmail) {
        MimeMessage message = createMail(accountEmail);
        javaMailSender.send(message);
        return number;
    }
}
