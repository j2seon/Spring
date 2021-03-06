package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//
@Controller
public class YoilTellerMVC2_1 {

	@ExceptionHandler(Exception.class) //에외를 처리하는 핸들러!!! >> 에러가 잡혔지만 해당 뷰의 내용을 꺼냄
	public String catcher(Exception e) { 
		e.printStackTrace();
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC2_1") //http://localhost:8282/ch2/getYoilMVC?year=2021&month=10&day=1
//	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
//	public void main(String year, String month , String day, HttpServletResponse response) throws IOException {
	public String main(@RequestParam(required = true)int year,
			@RequestParam(required = true)int month ,
			@RequestParam(required = true)int day, Model model) throws IOException {//입력을 직접받는걸로 처리해서 코드가 간단해졌다! 
		
		
		 //1.유효성 검사를 하는 메서드를 만들어준다.
		if(!isValid(year,month,day))
			return "yoilError";
		
		//2. 요일계산
		char yoil = getYoil(year, month, day); //WEB-INF/view/yoil.jsp > 반환하는 yoil이 String 이기 때문에 메서드의 반환타입을 변경해야한다.
		
		//3. 계산한 결과를 모델에 저장 모델에 저장하지 않으면 값들이 view로 넘어가지 않는다.
		model.addAttribute("year",year);
		model.addAttribute("month",month);
		model.addAttribute("day",day);
		model.addAttribute("yoil",yoil);
		
		return "yoil";
		/* 메서드로 따로 뺐다!!!
		 * Calendar cal = Calendar.getInstance(); //캘린더를 가져온다.
		   cal.set(year, month-1, day); //변환 없이 입력받은 값을 넣어준다.
		   int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1:일 ,2:월.....
	       char yoil=" 일월화수목금토".charAt(dayOfWeek);
	 
		return "yoil";*/    
	      
	     //3. 출력 부분은 별도의 jsp 파일로 작성할것임!!!
	     //jsp 파일은 src>main>webapp>WEB-INF>view에 작성하면된다
	}
	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance(); //캘린더를 가져온다.
		cal.set(year, month-1, day); //변환 없이 입력받은 값을 넣어준다.
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1:일 ,2:월.....
	    return" 일월화수목금토".charAt(dayOfWeek);
	
		
	}
	//유효성검사하는 메서드
	private boolean isValid(int year, int month, int day) {
		return true; //false로 하면 오류메세지만 나옴 ㅠㅠ
	}

	

	
	

}
