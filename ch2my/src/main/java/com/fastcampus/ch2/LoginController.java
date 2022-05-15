package com.fastcampus.ch2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.connector.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//1. 세션을 종료하고
		session.invalidate();
		//2. 홈화면으로 이동
		return "redirect:/"; 
	}
	
	
	@PostMapping("/login")
	public String login(@CookieValue("id") String cookieId , String  id, String pwd, boolean rememberId, String toURL, HttpServletRequest request, HttpServletResponse response) throws Exception {
						//@CookieValue는 id라는 이름가진쿠키값을 읽어서 String cookieId 로 넘김
		
		//1. id와 pwd를 확인
		if(!logincheck(id,pwd)) {
			//2-1 일치하지 않으면 loginForm으로 이동
			String msg = URLEncoder.encode("id 또는 password가 일치하지 않습니다.", "UTF-8");
		
			return "redirect:/login/login?msg="+msg;
		}

		//2-2. id와 pwd가 일치하면 
		//세션객체를 얻어와서 
		HttpSession session = request.getSession();
		 //세션객체에 id를 저장
		 session.setAttribute("id",id);
		if(rememberId) {
			//true이면 쿠키생성
			//1. 쿠키를 생성하고
			Cookie cookie = new Cookie("id", id);
			//2. 응답에 저장
			response.addCookie(cookie);
		}else {
			//false이면 쿠키생성 삭제
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			response.addCookie(cookie);

		}
			//3. 홈으로 이동
		//String toURL = "/"; //기본값
		//null이거나 빈문자열일때 > 홈으로 가고 그게아니면 toURL로 전달받은 값이 들어간다.
		toURL= toURL==null||toURL.equals("") ? "/" : toURL;
		
 		return "redirect:"+toURL; 
	}

	private boolean logincheck(String id, String pwd) {
		return "asdf".equals(id) && "asdf".equals(pwd);
	}
	
}
