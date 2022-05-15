package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestInfo1 {
	@RequestMapping("/RequestInfo1")
	public static void main(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String year = request.getParameter("year"); //getParameter
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		Iterator i = (Iterator) request.getParameterNames();
		Enumeration e = request.getParameterNames();
		Map map = request.getParameterMap();
		
		String[] yearArr =request.getParameterValues("year");
		//?year=2021&year=2022&year=2020
	}

}
