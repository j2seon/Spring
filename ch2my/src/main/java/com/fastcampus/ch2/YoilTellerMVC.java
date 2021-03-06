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
public class YoilTellerMVC {
	@ExceptionHandler(Exception.class) //에외를 처리하는 핸들러!!! >> 에러가 잡혔지만 해당 뷰의 내용을 꺼냄
	public String catcher(Exception e) { 
		e.printStackTrace();
		return "yoilError";
	}
	
	
	@RequestMapping("/getYoilMVC") //http://localhost:8282/ch2/getYoilMVC?year=2021&month=10&day=1
//	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
//	public void main(String year, String month , String day, HttpServletResponse response) throws IOException {
	//public String main(int year, int month , int day, Model model) throws IOException {//입력을 직접받는걸로 처리해서 코드가 간단해졌다! 
//	public void main(int year, int month , int day, Model model) throws IOException {	 
		//String 대신에 반환타입을 void로 하고 반환타입을 반환하지 않을 수 있다 그럼녀 view의 이름은 mapping된 url에 의해 이름이 결정된다
	public ModelAndView main(@RequestParam(required = true) int year, 
			@RequestParam(required = true)int month ,
			@RequestParam(required = true)int day) throws IOException {	 
		// ModelAndView로도 할 수 있다.>> 객체 만들어줘야함
		
		ModelAndView mv =new ModelAndView(); // 잘쓰지는 않으나 알아두면 좋을 듯
		
	
		//2. 요일계산
		char yoil =getYoil(year, month, day);
	    
		
		mv.addObject("year",year);
		mv.addObject("month",month);
		mv.addObject("day",day);
		mv.addObject("yoil",yoil);
		
		//4. 결과를 보여줄 view를 지정
		mv.setViewName("yoil");
		return mv;
//	    return "yoil"; // /WEB-INF/view/yoil.jsp > 반환하는 yoil이 String 이기 때문에 메서드의 반환타입을 변경해야한다.
	        
	      
	     //3. 출력 부분은 별도의 jsp 파일로 작성할것임!!!
	     //jsp 파일은 src>main>webapp>WEB-INF>view에 작성하면된다
	}

	//유효성검사하는 메서드
	private boolean isValid(int year, int month, int day) {    
    	if(year==-1 || month==-1 || day==-1) 
    		return false;
    	
    	return (1<=month && month<=12) && (1<=day && day<=31); // 간단히 체크 
    }
	//요일을 계산하는 메서드
	private char getYoil(int year, int month, int day) {
	     Calendar cal = Calendar.getInstance();
	     cal.set(year,month-1,day);
	     
	     int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1:일 ,2:월.....
	     return " 일월화수목금토".charAt(dayOfWeek);
	}

}
