<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

table, th, td {
	border: 1px solid #ccc;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
}

</style>

</head>
<body>

<h1>사원 상세 정보</h1>
<hr>

<table>
<thead>
<tr>
<tr>
	<td>사원번호</td>
	<td>사원이름</td>
	<td>직무</td>
	<td>매니저</td>
	<td>입사일</td>
	<td>급여</td>
	<td>상여금</td>
	<td>부서번호</td>
</tr>
<tr>
</thead>
<tbody>
<tr>
	<td>${empDetail.empno }</td>
	<td>${empDetail.ename }</td>
	<td>${empDetail.job }</td>
	<td>${empDetail.mgr }</td>
	<td><fmt:formatDate value="${empDetail.hiredate }" pattern="yyyy-MM-dd" /></td>
	<td>${empDetail.sal }</td>
	<td>${empDetail.comm }</td>
	<td>${empDetail.deptno }</td>
</tr>
</tbody>


</table>

</body>
</html>