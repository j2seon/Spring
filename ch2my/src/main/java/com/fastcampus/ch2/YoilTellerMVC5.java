package com.fastcampus.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


//@ModelAttribute model 의 속성으로 자동추가해주는 에너테이션 반환타입 또는 컨트롤러 메서드의 매개변수에 적용!!!
//@ModelAttribute 를 사용하게되면 결과를 저장하거나 호출할 필요가 없어진다. 
//참조형 매개변수 앞에 ModelAttribute를 붙일 수 있다!!  (생략가능) 즉 앞에서 섰던 것들도 호출과 결과를 저장하지 않아도 된다!!!!

/*컨트롤러 매개변수
 * 
 * @RequestParam - 기본형
 * 
 * @ModelAttribute - 참조형
 * 
 * 
 * */ 

@Controller
public class YoilTellerMVC5 {
    @ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		System.out.println("ex="+ex);
		
		return "yoilError";
	}
    
    @RequestMapping("/getYoilMVC5") // http://localhost/ch2/getYoilMVC5?year=2021&month=10&day=1
//  public String main(@ModelAttribute("myDate") MyDate date, Model m) { // 아래와 동일 
    public String main(@ModelAttribute MyDate date, Model m) { // @ModelAttribute사용, 반환 타입은 String  
    	  				//모델에 자동자장시킨다. 별도로 써주지 않는다면 첫글자를 소문자로한 형태 : myDate!
    	System.out.println("myDate="+date);

    	// 1. 유효성 검사 
    	if(!isValid(date))
    		return "yoilError";
    	
        // 2. 처리
    	//char yoil = getYoil(date);

    	// 3. Model에 작업한 결과를 저장 
        // @ModelAttribute 덕분에 MyDate를 저장안해도 됨. View로 자동 전달됨!!!! 
//      m.addAttribute("myDate", date);     myDate가 key가 되고 date가 value 형태로 들어간다.	
//      m.addAttribute("yoil", yoil);        
        
      	// 4. 작업 결과를 보여줄 뷰의 이름을 반환  
      	return "yoil";
    }
    
    private @ModelAttribute("yoil") char getYoil(MyDate date) { //반환타입 앞에도 @ModelAttribute를 적용한다. 호출결과를 저장한다.
    	return getYoil(date.getYear(), date.getMonth(), date.getDay()); // @ModelAttribute("yoil")<<yoil을 key로!!
    }
    
    private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);
    }

    private boolean isValid(MyDate date) {
    	return isValid(date.getYear(), date.getMonth(), date.getDay());
    }
    
    private boolean isValid(int year, int month, int day) {    
    	if(year==-1 || month==-1 || day==-1) 
    		return false;
    	
    	return (1<=month && month<=12) && (1<=day && day<=31); // 간단히 체크 
    }
}






 