<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>스프링 MVC 테스트</h1>
<hr>

<table border="1">
<c:forEach items="${list }" var="i">
<tr>
	<td>${i.deptno }</td>
	<td>${i.dname }</td>
	<td>${i.loc }</td>
</tr>
</c:forEach>
</table>

</body>
</html>