package com.fastcampus.ch2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
//	@RequestMapping("/register/add") //신규회원 가입은 get으로 add는 단순히 화면만 보여준다.
		@RequestMapping(value="/register/add", method= {RequestMethod.GET,RequestMethod.POST}) // 신규회원 가입
//		@GetMapping("/register/add") // 4.3부터 추가
		public String register() {
			return "registerForm";  // WEB-INF/views/registerForm.jsp
		}
	
	/*	src > main> webapp > web-inf > Spring > appServlet> servlet-comtext.xml에 해당 문장 추가하면 위의 내용을 적을 필요가 없다.
	 * 
	 * <view-controller path="/register/add" view-name="registerForm"/>
	 * 
	 * 이렇게 추가하면 get 요청으로만!!!
	*/
	
	
	//@RequestMapping(value = "/register/save", method = RequestMethod.POST) //포스트형식으로만 받을 수 있게 설정.
	@PostMapping("/register/save")
	public String save(@ModelAttribute("user") User user, Model m) throws Exception {
		//1. 유효성 검사
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "UTF-8");
			m.addAttribute("msg" , msg);
			return "forward:/register/add";
			//return "redirect:/register/add?msg="+msg;//재작성(rewriting)
		}
		
		//2.db에 신규회원 정보를 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return false;
	}
}
