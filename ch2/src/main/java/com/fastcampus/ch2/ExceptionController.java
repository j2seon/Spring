package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class })
	public String catche2(Exception ex, Model model ) {
		model.addAttribute("ex",ex);
		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model model) {
		System.out.println("m="+model); //여기있는 model은 error를 담기위해서 있는 것!!!
		model.addAttribute("ex",ex);
		return "error";
	}
	
	@RequestMapping("/ex")
	public String main(Model model) throws Exception {
		model.addAttribute("msg", "message from ExceptionController.main()");
			throw new Exception("예외가 발생했습니다.");
	}
	
	@RequestMapping("/ex2")
	public String main2() throws Exception {
			throw new FileNotFoundException("예외가 발생했습니다.");
	}
	
	
	
}
