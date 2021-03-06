package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) throws Exception {
		//Hello hello = new Hello();
		//hello.main(); //private이라서 외부 호출불가.
		
		
		/*그럼 아까는 왜 가능????
		 * 
		 * Reflection API를 사용 - 클래스 정보를 업고 다를 수 있는 강력한 기능 제공
		 * java.lang.reflect를 제공한다.
		 * 스프링프레임워크가 자주사용한다~
		 * 
		 * */
		
		//Hello클래스의 Class객체(클래스의 정보를 담고있는 객체)를 얻어온다. 이걸이용하면 Hello 객체정보를 가져올 수 있다
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		Hello hello = (Hello) helloClass.newInstance(); //Class객체가 가진 정보로 객체 생성 반환타입이 object라서 형변환이 필요
		
		//Hello클래스의 메소드를 getDeclaredMethod이용해서 main에 담고
		Method main = helloClass.getDeclaredMethod("main");
		
		//접근 가능하도록 설정한다.
		main.setAccessible(true);// private인 main()을 호출가능하게 한다.
		
		main.invoke(hello); // hello.main()과 같은 의미!!!

		
		
		
		
		
	}
}
