<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
</head>
<body>
	<h1>list.jsp</h1>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>가입날짜</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
		<c:forEach var="i" items="${lists }">
			<tr>
				<td>${i.num }</td>
				<td>${i.id }</td>
				<td>${i.passwd }</td>
				<td>${i.name }</td>
				<td>${i.register }</td>
				<td>수정</td>
				<td><a href="delete.do?num=${i.num }">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="insertForm.jsp">삽입</a>
</body>
</html>