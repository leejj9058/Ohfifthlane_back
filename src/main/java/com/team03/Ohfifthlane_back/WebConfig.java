package com.team03.Ohfifthlane_back;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 로그인 체크 인터셉터 등록
		registry.addInterceptor(new LoginInterceptor())
				// 로그인 필수 경로 설정
				.addPathPatterns("/reservation", "/parkingPay", "/residentReportWrite", "/residentReport",
						"/updateRegister", "/qrcodereport", "/qrcode", "/reportList", "/setParking")
				// 로그인 불필요 경로 설정 (로그인, 회원가입, 아이디찾기 등)
				.excludePathPatterns("/login", "/register", "/findId", "/map", "/about", "/home", "/notice", "/board");
	}
}
