package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1.���� ȣ�� ������ ���α׷����� ��� 

@Controller
public class Hello {
	int iv =10; //�ν��Ͻ� ����
	static int cv=20; //static ���� 
	
	
	
	//2.url�� �޼��� ���� > hello��� url�� main()�� ����Ǿ���.
	@RequestMapping("/hello")
	private void main() { //static�� ��� ����ǳ�? �ν��Ͻ� �޼��� > �ν��Ͻ� �޼���� iv ,cv �� �� �� ��밡��
		System.out.println("Hello - static ");
		System.out.println(cv); //ok
		System.out.println("Hello"); //���� �ܼ��� ���� ����� �Ǿ���.
	} //private���� �ص� ����� �ȴ� : RequestMapping�� �Ѱ� �ܺο��� ȣ��ǰ��ϰڴٴ� �ǹ̴ϱ� �����Ѱ�
	
	public static void main2() { //static �޼ҵ� >> cv�� ��밡�� 
		System.out.println(cv); //ok
//		System.out.println(iv); //����
		
	} 
	
}
//�������� ������ �ʴ������� System.out���� �ֿܼ� ��������ϱ�!

/*static�� ��� ����Ǵ�����??
 * 
 * ȣ�������� �ν��Ͻ��޼���� ȣ��ȴ�. �ν��Ͻ��޼ҵ�� ��ü�� �����Ǿ�� ��밡���ϴ�.
 * �׷� ��ü�� ���� ����?
 * ȣ���ϸ� ������ ��ü�� �������ش�. ��ü�� �������ֱ⶧���� �޼��尡 ȣ�Ⱑ��! �׷��� static�� ��� �����ȴ�.
 * static�� ��� static �����鸸 ����� �� �ֱ� ������ �ν��Ͻ��޼���� ����� ���� ����~
 * 
 * 
 * */
 