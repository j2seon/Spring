package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController {
	
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED) //405로 바꿧음.
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class })
	public String catche2(Exception ex, Model model ) {
		//model.addAttribute("ex",ex);
		return "error"; // 에러가 발생했음에도 error view로 값이 넘어가니까 200번대가 (요청성공) > but 예외가 발생한 상태잖아? 그럴 때 응답코드를 변경할 수 있음.
													//+ 사용자정의 예외클래스에도 사용한다.
	}
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model model) {
		System.out.println("m="+model); //여기있는 model은 error를 담기위해서 있는 것!!!
		//model.addAttribute("ex",ex); // <%@ page isErrorPage="true"를 적어주면 add 할 필요가 없어진다!!>
		return "error"; 
	}
	
	@RequestMapping("/ex")
	public String main(Model model) throws Exception { //위의 model과 다른 객체이다!! 
		model.addAttribute("msg", "message from ExceptionController.main()");
			throw new Exception("예외가 발생했습니다.");
	}
	
	@RequestMapping("/ex2")
	public String main2() throws Exception {
			throw new FileNotFoundException("예외가 발생했습니다.");
	}
	
	
	
}
