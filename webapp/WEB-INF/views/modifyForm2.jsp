<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>phone book model 5</title>
</head>
<body>

	<h1>이다현 전화번호 수정화면</h1>
	<p>
		수정 화면입니다.
		아래 항목을 수정하고 "수정"버튼을 누르세요.
	</p>
	
	<!-- map은 getter가 아니라 key값으로 꺼내옴. --> 
	<!-- 소문자로 쓰고 싶으면 쿼리문에서 컬럼명을 소문자로 바꾸는 함수 써야 됨. -->
	<form action="${pageContext.request.contextPath}/phone/modify" method="get">
		이름(name) : <input type="text" name="name" value="${requestScope.pMap.NAME }"><br> 
		핸드폰(hp) : <input type="text" name="hp" value="${requestScope.pMap.HP }"><br>
		회사(company) : <input type="text" name="company" value="${requestScope.pMap.COMPANY }"><br>
		코드(id) : <input type="text" name="personId" value="${requestScope.pMap.PERSONID }"> <br>
		<br>
		
		<button type="submit">수정</button>
	</form>
	
</body>
</html>