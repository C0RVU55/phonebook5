<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>phone book model 5</title>
</head>
<body>
	<h1>전화번호 등록</h1>
	
	<p>
		전화번호를 등록하려면<br>
		아래 항목을 기입하고 "등록"버튼을 누르세요.
	</p>
	
	<form action="${pageContext.request.contextPath}/phone/write" method="get">
		이름(name): <input type="text" name="name"> <br> <!-- name, value값 없으면 비워둠 -->
		핸드폰(hp): <input type="text" name="hp"> <br>
		회사(company): <input type="text" name="company" > <br>
		
		<!-- action은 이제 필요없음 --> <br>		
		<button type="submit">등록</button>
	</form>
	
	<br>
	
	<a href="${pageContext.request.contextPath}/phone/list">리스트 바로가기</a>
</body>
</html>