package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) throws Exception {
		//Hello hello = new Hello();
		//hello.main(); //private�̶� �ܺ� ȣ��Ұ�.
		
		
		/*�׷� �Ʊ�� �� ����????
		 * 
		 * Reflection API�� ��� - Ŭ���� ������ ���� �ٸ� �� �ִ� ������ ��� ����
		 * java.lang.reflect�� �����Ѵ�.
		 * �����������ӿ�ũ�� ���ֻ���Ѵ�~
		 * 
		 * */
		
		//HelloŬ������ Class��ü(Ŭ������ ������ ����ִ� ��ü)�� ���´�. �̰��̿��ϸ� Hello ��ü������ ������ �� �ִ�
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		Hello hello = (Hello) helloClass.newInstance(); //Class��ü�� ���� ������ ��ü ���� ��ȯŸ���� object�� ����ȯ�� �ʿ�
		
		//HelloŬ������ �޼ҵ带 getDeclaredMethod�̿��ؼ� main�� ���
		Method main = helloClass.getDeclaredMethod("main");
		
		//���� �����ϵ��� �����Ѵ�.
		main.setAccessible(true);// private�� main()�� ȣ�Ⱑ���ϰ� �Ѵ�.
		
		main.invoke(hello); // hello.main()�� ���� �ǹ�!!!

		
		
		
		
		
	}
}