package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1.원격 호출 가능한 프로그램으로 등록 

@Controller
public class Hello {
	int iv =10; //인스턴스 변수
	static int cv=20; //static 변수 
	
	
	
	//2.url과 메서드 연결 > hello라는 url과 main()이 연결되었다.
	@RequestMapping("/hello")
	private void main() { //static이 없어도 실행되네? 인스턴스 메서드 > 인스턴스 메서드는 iv ,cv 를 둘 다 사용가능
		System.out.println("Hello - static ");
		System.out.println(cv); //ok
		System.out.println("Hello"); //밑의 콘솔을 보면 출력이 되었다.
	} //private으로 해도 출력이 된다 : RequestMapping을 한게 외부에서 호출되게하겠다는 의미니까 가능한것
	
	public static void main2() { //static 메소드 >> cv만 사용가능 
		System.out.println(cv); //ok
//		System.out.println(iv); //에러
		
	} 
	
}
//브라우저에 나오지 않는이유는 System.out으로 콘솔에 출력했으니까!

/*static이 없어도 실행되는이유??
 * 
 * 호출했을때 인스턴스메서드로 호출된다. 인스턴스메소드는 객체가 생성되어야 사용가능하다.
 * 그럼 객체는 누가 생성?
 * 호출하면 톰켓이 객체를 생성해준다. 객체를 생성해주기때문에 메서드가 호출가능! 그래서 static이 없어도 생성된다.
 * static의 경우 static 변수들만 사용할 수 있기 때문에 인스턴스메서드로 만드는 것이 좋다~
 * 
 * 
 * */
 