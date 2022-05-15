package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) //500에서 400 이 나올수 있도록 한다 원할때! 
class MyException extends RuntimeException{
	MyException(String msg){
		super(msg);
	}
	MyException(){this("");}
}


@Controller
public class ExceptionController2 {
	@RequestMapping("/ex3") //GlobalCatcher 에서 예외처리를 한다.@ControllerAdvice("com.fastcampus.ch2")일경우 
	public String main() throws Exception {
			throw new MyException("예외가 발생했습니다.");
	}
	
	@RequestMapping("/ex4")
	public String main2() throws Exception {
			throw new FileNotFoundException("예외가 발생했습니다.");
	}
	
	
	
}
