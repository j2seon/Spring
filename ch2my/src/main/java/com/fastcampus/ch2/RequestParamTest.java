package com.fastcampus.ch2;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


//필수 입력이 아닐때 (required=false)인 경우에는 defaultValue 값을 주어야한다!!!! 11에서 확인



@Controller
public class RequestParamTest {
	
	//오류가 날 경우 처리하는 메서드를 만들어준다! 
	@ExceptionHandler(Exception.class) //괄호 안의 예외가 발생했을 때 실행 처리한 결과를 
	public String catcher(Exception ex) {
		return "yoilError"; //yoilError를 통해서 보여준다.
	}
	
	@RequestMapping("/requestParam")
	public String main(HttpServletRequest request) {
		String year = request.getParameter("year");
//		http://localhost/ch2/requestParam         ---->> year=null
//		http://localhost/ch2/requestParam?year=   ---->> year=""
//		http://localhost/ch2/requestParam?year    ---->> year=""
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}

	@RequestMapping("/requestParam2")
//	public String main2(@RequestParam(name="year", required=false) String year) {   // 아래와 동일 
	public String main2(String year) {   //생략이 가능하다! 
//		http://localhost/ch2/requestParam2         ---->> year=null
//		http://localhost/ch2/requestParam2?year    ---->> year=""
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}

	@RequestMapping("/requestParam3") //required=true 라면 year를 필수적으로 입력해야한다!!!
//		public String main3(@RequestParam(name="year", required=true) String year) {   // 아래와 동일 
		public String main3(@RequestParam String year) {   
//		http://localhost/ch2/requestParam3         ---->> year=null   400 Bad Request. required=true라서 
		//400번 >> 필수입력인데 클라이언트가 입력하지 않았기 때문에!! 
//		http://localhost/ch2/requestParam3?year    ---->> year="" 빈문자열은 값이 넘어온것으로 봐서 에러가 아니다.!!!!!
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";	
	}
	
	/* 외울 필요없다! 필요하면 required=true를 명시적으로 적어주기만 하면된다!! 
	 * */
	
	
	@RequestMapping("/requestParam4")
	public String main4(@RequestParam(required=false) String year) {   
//		http://localhost/ch2/requestParam4         ---->> year=null 
//		http://localhost/ch2/requestParam4?year    ---->> year=""   
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}

	@RequestMapping("/requestParam5")
	public String main5(@RequestParam(required=false, defaultValue="1") String year) {   
//		http://localhost/ch2/requestParam5         ---->> year=1   
//		http://localhost/ch2/requestParam5?year    ---->> year=1   
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
// =======================================================================
	
	@RequestMapping("/requestParam6") 
	public String main6(int year) {   
//		http://localhost/ch2/requestParam6        ---->> 500 java.lang.IllegalStateException: Optional int parameter 'year' is present but cannot be translated into a null value due to being declared as a primitive type. Consider declaring it as object wrapper for the corresponding primitive type.
//		http://localhost/ch2/requestParam6?year   ---->> 400 Bad Request, nested exception is java.lang.NumberFormatException: For input string: "" 
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
	@RequestMapping("/requestParam7") 
	public String main7(@RequestParam int year) {   
//		http://localhost/ch2/requestParam7        ---->> 400 Bad Request, Required int parameter 'year' is not present
//		http://localhost/ch2/requestParam7?year   ---->> 400 Bad Request, nested exception is java.lang.NumberFormatException: For input string: "" 
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}

	@RequestMapping("/requestParam8") //int 값을 매개변수로 주었다. //defaultValue 넣어주면 실제로 받은 값ㅇs null인데 defaultValue의 값이 들어가는 것을 볼수있다!!!
	public String main8(@RequestParam(required=false, defaultValue ="2020") int year) {   
	//	http://localhost/ch2/requestParam8        ---->> 500 java.lang.IllegalStateException: Optional int parameter 'year' is present but cannot be translated into a null value due to being declared as a primitive type. Consider declaring it as object wrapper for the corresponding primitive type.
		// 필수입력이 아니라서 안넣었기 때문에 클라이언트는 제대로 한것! 
		// but 아무것도 안넣게되면 null 값이 들어가는데 int형에는 null이 변환 할 수 없다!!!
		
	//	http://localhost/ch2/requestParam8?year   ---->> 400 Bad Request, nested exception is java.lang.NumberFormatException: For input string: "" 
		//year만 적었기 때문에 ""(빈문자)가 오게 된다. 즉 클라이언트가 갑을 주긴줬는데 int형을 주지 않았기 때문에 400번대 에러
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
	@RequestMapping("/requestParam9") //필수입력인상태! 
	public String main9(@RequestParam(required=true) int year) {   
	//	http://localhost/ch2/requestParam9        ---->> 400 Bad Request, Required int parameter 'year' is not present
		//입력하지 않았기 때문에 400번 에러
	//	http://localhost/ch2/requestParam9?year   ---->> 400 Bad Request, nested exception is java.lang.NumberFormatException: For input string: ""
		// 빈문자열이기 때문에 int로 변환할 수 없기 때문에  400번 에러
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
	@RequestMapping("/requestParam10")
	public String main10(@RequestParam(required=true, defaultValue="1") int year) {   
	//	http://localhost/ch2/requestParam10        ---->> year=1   
	//	http://localhost/ch2/requestParam10?year   ---->> year=1   
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}

	@RequestMapping("/requestParam11")  //필수입력이 아닐때 기본값은 1
	public String main11(@RequestParam(required=false, defaultValue="1") int year) {   
//		http://localhost/ch2/requestParam11        ---->> year=1   
//		http://localhost/ch2/requestParam11?year   ---->> year=1  
		//---> null이거나 쓰지 않았을때 기본값이 1이 주어지는 것을 알 수있다.
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
} // class