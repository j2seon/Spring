package com.fastcampus.ch2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	@GetMapping("/list")
	public String list(HttpServletRequest request) {
		if(!loginCheck(request)) {//로그인화면에게 get방식으로 url을 보낸다. 
			return "redirect:/login/login?toURL="+request.getRequestURL(); //로그인 안했으면 로그인화면으로 이동한다.
		}
		return "boardList"; //했으면 게시판화면으로 이동
	}

	private boolean loginCheck(HttpServletRequest request) {
		//1. 세션을 얻어서
		HttpSession session = request.getSession();
		//2. 세션에 id가 있는지 확인, 있으면 true를 반환한다.

		return session.getAttribute("id")!=null; 
	}
}
