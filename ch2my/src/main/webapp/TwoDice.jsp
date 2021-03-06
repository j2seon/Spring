<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.Random" %>
<%-- <%! 클래스 영역 %> --%>
<%!  
	int getRandomInt(int range){
		return new Random().nextInt(range)+1;
	}
%>
<%-- <%  메서드 영역 - service()의 내부 %> --%>
<%
	int idx1 = getRandomInt(6);
	int idx2 = getRandomInt(6);
%>
<html>
<head>
	<title>twoDice.jsp</title>
</head>
<body>
	<img src='resources/img/dice<%=idx1%>.jpg'>
	<img src='resources/img/dice<%=idx2%>.jpg'>
</body>
</html>

<!-- JSP란 html안에 자바코드가 있는것! 

jsp요청이 오면 jspservlet이 받아서 인스턴스가 존재하는지 확인한다. jsp요청 > jspservlet(인스턴스유무확인)

no>> twoDice.jsp > twoDice_jsp.java로 변환> 컴파일을 해서 > 객체를 생성 >>응답
* 수정될때 마다 다시 변환작업을 거친다 >> 시간이 지연된다.

서블릿 > 늦은초기화가 기본
spring은 이를 개선하기위해 > early 초기화
둘다 싱글톤으로 되어 있으나 초기화에 있어서 차이가 있다.

jsp는 기본객체 존재 : 생성없이 사용할 수 있는 객체를 의미
ex)request ,respones pageContext , out, session page(객체 자신)등등


유효범위와 속성
http의 특징> 상태정보를 저장하지 않는다 따라서 따로 '저장소'가 필요하다.

저장소는 접근범위와 생존기간에 따라 4개의 저장소가 존재한다. > 저장소는 map형태로 이루어져있다.
해당 저장소에 저장하기 위한 메소드가 setAttribute() , 읽기위한 메소드는 getAttribute() 



1.pageContext 
 - lv(지역변수)를 저장한다 > 기본객체도 lv!! 
 - 범위는 page 안! 기본객체를 EL에서 쓰려면 pageContext를 거쳐서 써야한다. EL은 <%=%>이 사용하기 편하게 만든것 ${}
 -요청할때마다 새로 초기화가 된다.
 
 2. application 
  - webapp전체에서 접근 가능하다. 1개만 존재  > 공통저장소! 
  - 전체에서 공유하기 때문에 여기에 직접적으로 저장하는것은 좋지 않다. 그걸 해결하기 위해 제공되는게 session! 

 3. session 
  - 개별 저장소 ! 클라이언트마다 1개씩 가진다.
  - 로그인을 한다? 그럼 id를 key로 해서 session에 저장된다. 로그인하면 이 개별저장소가 생겼다가 로그아웃하면 개별저장소가 없어짐!
  - 따라서 session에는 사용자만 사용할 수 있는 것을 저장하면 좋다 ex 장바구니 로그인 
  - 사용자마다 1개 가 생기기 때문에 서버부담이 제일크다 (사용자가 10,000이면 10,000개가 생기니까)

 4. request
  - 요청할때마다 생긴다. 요청이 하나의 jsp page에 전달되고 응답을 받는다. 
  - 보통은 한 응답은 하나의 jsp페이지가 담당하고 응답하는데 반드시그런것은 아님
   - jsp에 요청이 왔는데 다른 jsp로 넘겨줄수 있다 이걸 forward라고 한다! request는 다른 jsp로 전달이 가능함.
   
   
   * 저장소 중 저장하기 쉬운 객체는 session이지만 부담이 크기때문에 request 객체를 이용하는 편이 좋다!! 



-->