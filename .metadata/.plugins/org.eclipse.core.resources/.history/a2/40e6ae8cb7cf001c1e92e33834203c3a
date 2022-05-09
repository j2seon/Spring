package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1.원격호출가능한 프로그램으로 등록

@Controller
public class Hello {
	int iv =10; //인스턴스변수
	static int cv=20; //static 변수
	
	
	
	//2.url과 메서드 연결 > hello라는 url과 main이 연결되었다.
	@RequestMapping("/hello")
	private void main() { //static이 없어도 실행되네? 인스턴스메서드로 하자>인스턴스 메서드는 iv,cv를 둘다 사용하근ㅇ
		System.out.println("Hello - static ");
		System.out.println(cv); //ok
		System.out.println("Hello"); 
	} //private여도 출력이 된다 : RequestMapping은 외부에서 호출할거야라는 의미니까.
	
	public static void main2() { //static메서드 cv만 가능
		System.out.println(cv); //ok
//		System.out.println(iv); //에러
		
	} 
	
}
//브라우저에나오지 않는이유는 System.out으로 콘솔에 출력했으니까

/*static
 * 
 * 인스턴스 메서드는 객체가 생성되어야 사용이 가능! 누군가가 객체를 생성해준 것이다.

원격 프로그램에서는 호출 시에 톰켓이 객체를 생성해준다!

따라서 static이 없어도 객체가 생성되기 때문에 인스턴스메서드가 호출 가능한 것!

추가적으로 static 메서드는 static의 변수만 사용가능하기 때문에 인스턴스메서드로 사용하는 것이 더 좋다고 한다.
 * 
 * 
 * 
 * */
 