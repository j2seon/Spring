package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex {
	@RequestMapping("/e")
	public void main(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		
	
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("�̸� : "+name+" ���� : "+gender);
		out.println("</body>");
		out.println("</html>");

		
	}

}
