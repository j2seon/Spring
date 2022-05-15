package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception {
//		Hello hello = new Hello();
//		hello.main(); // private�̶� �ܺ� ȣ�� �Ұ�
		
		// Reflection API�� ��� - Ŭ���� ������ ��� �ٷ� �� �ִ� ������ �������
		// java.lang.reflect��Ű���� ����
		
		// HelloŬ������ Class��ü(Ŭ������ ������ ��� �ִ� ��ü)�� ���´�.
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		
		// Class��ü�� ���� ������ ��ü ����
		Hello hello = (Hello)helloClass.newInstance();
		
		// main�̶�� �޼��� ���� ��������
		Method main = helloClass.getDeclaredMethod("main");
		
		// private�� main()�� ȣ�� �����ϰ� �Ѵ�.
		main.setAccessible(true);  
		
		main.invoke(hello); //hello.main(); 
	}

}
