<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.fastcampus.ch2_1.*" %>
<%
	Person person = new Person();
	request.setAttribute("person", person);
	request.setAttribute("name", "남궁성");   
	request.setAttribute("list", new java.util.ArrayList());	
%>
<html>  
<head>   
	<title>EL</title>   
</head>  
<body>   
	person.getCar().getColor()=<%=person.getCar().getColor()%> <br>
	person.getCar().getColor()=${person.getCar().getColor()} <br>
	person.getCar().getColor()=${person.car.color} <br>   <!-- person.car.color 간단히 하려고 이렇게 쓴거임.  -->  
	name=<%=request.getAttribute("name")%> <br>   
	name=${requestScope.name} <br>
	name=${name} <br> <!-- requestScope.name와 결국 같은의미임.  -->
	id=<%=request.getParameter("id")%> <br>
	id=${pageContext.request.getParameter("id")} <br>
	id=${param.id} <br> <!-- EL은 null 을 출력하지 않는다. -->
	"1"+1 = ${"1"+1} <br><!-- EL은 에서는 1+1로 인식한다. -->
	"1"+="1" = ${"1"+="1"} <br><!-- 문자열로 두고 싶으면 +=를 이용해야한다. -->
	"2">1 = ${"2">1} <br>   
	null = ${null}<br><!-- EL은 null 을 출력하지 않는다. -->
	null+1 = ${null+1} <br><!-- null을 0으로 인식 -->
	null+null = ${null+null} <br>
	"" + null = ${""+null} <br>   
	""-1 = ${""-1} <br> 
	empty null=${empty null} <br><!--empty null인지 빈칸인지  -->
	empty list=${empty list} <br>
	null==0 = ${null==0} <br>
	null eq 0 = ${null eq 0} <br>
	name == "남궁성"=${name=="남궁성"} <br><!-- ==이랑 eq가 같은거 -->
	name != "남궁성"=${name!="남궁성"} <br> <!-- ! 랑 ne 같은거 > not equels -->
	name eq "남궁성"=${name eq "남궁성"} <br>  
	name ne "남궁성"=${name ne "남궁성"} <br>  
	name.equals("남궁성")=${name.equals("남궁성")} <br>   
</body>
</html>