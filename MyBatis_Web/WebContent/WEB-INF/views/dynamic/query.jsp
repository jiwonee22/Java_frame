<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>동적 SQL 테스트</h1>
<hr>

<table border="1">
<c:forEach items="${list }" var="i">
<tr>
	<td>${i.EMPNO }</td>
	<td>${i.ENAME }</td>
	<td>${i.HIREDATE }</td>
	<td>${i.DEPTNO }</td>
</tr>
</c:forEach>
</table>

<button onclick="location.href='/dynamic/query2';">부서</button>

</body>
</html>