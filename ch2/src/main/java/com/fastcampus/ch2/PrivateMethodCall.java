package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception {
		//Hello hello = new Hello();
		//hello.main(); //private
		
		
		/*
		 * 
		 * Reflection API
		 * java.lang.reflect.
		 * 스프링에서 자주사용한다!
		 * 
		 * */
		
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		Hello hello = (Hello) helloClass.newInstance(); 
		
		//Hello getDeclaredMethod main
		Method main = helloClass.getDeclaredMethod("main");
		
		main.setAccessible(true);// private
		
		main.invoke(hello); // hello.main()

		
		
		
		
		
	}
}
