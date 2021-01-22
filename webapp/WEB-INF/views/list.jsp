<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>phone book model 5</title>
</head>
<body>

	<h1>전화번호 리스트</h1>
	<h3>입력한 정보 내역입니다</h3>
	
	<%--requestScope인데 디스패처서블렛이 컨트롤러에서 받은 데이터(주소값)을 request에 넣어놓고 jsp가 request에서 꺼내오는 거. --%>
	<c:forEach items="${pList}" var="vo" > 
		<table border="1">
			<tr>
				<td>이름(name)</td>
				<td>(${vo.personId }) ${vo.name }</td> <%--변수명 vo랑 같아야 됨 --%>
			</tr>
			<tr>
				<td>핸드폰(hp)</td>
				<td>${vo.hp }</td>
			</tr>
			<tr>
				<td>회사(company)</td>
				<td>${vo.company }</td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/phone/modifyForm?personId=${vo.personId }">수정</a></td>
				<%--톰캣이랑 연결되는 주소 '/프로젝트명'을 변수로 불러와주는 el. 일일이 숫자 안 바꿔도 됨.  --%>
				<td><a href="${pageContext.request.contextPath}/phone/delete/${vo.personId }">삭제</a></td> <%--PathVariable 쓸 때 --%>
			</tr>
		</table>
		<br>
	</c:forEach>
	
	<a href="${pageContext.request.contextPath}/phone/writeForm">추가번호 등록</a> 
	<%-- 링크 걸 때 그냥 파일 위치 쓰면 안 되고 controller 거쳐서 action 파라미터값으로 들어가는 주소 써야됨 --%>
</body>
</html>