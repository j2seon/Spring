package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
//jsp와 서블릿은 거의 유사함! 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
//서블릿은 HttpServlet를 상속받아야한다.


//요청이 오면 servlert context에서 요청을 확인한다. (서블릿 인스턴스가 존재하는지?) >> no > 서블릿 클래스 로딩/인스턴스를 생성 > init(),service()> 응답
																//>> yes > service() 호출 > 응답
//서블릿이 변경되거나 제거될때 destory가 호출되는 것!!
//서블릿은 기본적으로 싱글톤(single ton), 1개의 인스턴스만 만들어진다. 요청할때마다 객체를 만드는게 아니라 있으면 재활용 !


@WebServlet("/hello")
public class HelloServlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		//서블릿이 초기화 될때 자동 호출되는 메서드!  > 처음에 한번만 호출이 된다.
		//1. 서블릿의 초기화 작업을 담당한다.
		System.out.println("init메소드");
	
	} 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//실제로 작업을 처리하는 메소드 > init이 한번만 호출이 되고 요청이 올때마다 service가 반복적으로 호출된다.
		//1.입력 
		//2.처리
		//3.출력
		System.out.println("service 메소드");
	}

	@Override
	public void destroy() {
		//3. 뒷정리 - 서블릿이 메모리에서 제거될때 컨테이너에 의해서 자동 호출 > 톰켓이 자동으로 restart 될때 보면 중간에 destroy가 있다.
		System.out.println("destory 메소드");
	}


}


