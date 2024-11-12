package com.team03.Ohfifthlane_back;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler)
			throws Exception {

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		
		System.out.println("인터셉터 적용" + request.getRequestURI());
		System.out.println("userId : " + userId);

		if (userId == null || userId.isEmpty()) { // userId가 없으면 로그인 페이지로 리디렉션
			response.sendRedirect("/login");
			return false; // 요청 처리 중지
		}

		// 로그인된 상태이면 요청을 계속 처리
		return true;
	}
}
