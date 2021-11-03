<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<h1>파일 리스트</h1>
<hr>

<table>
<thead>
<tr>
	<td>파일번호</td>
	<td>제목</td>
	<td>원본 파일명</td>
</tr>
</thead>

<tbody>
<c:forEach items="${fileList }" var="file">
<tr>
	<td><a href="/file/download?fileno=${file.fileno }">${file.fileno }</a></td>
	<td>${file.title }</td>
	<td><a href="/upload/${file.storedName }" download="${file.originName }">${file.originName }</a></td>
</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>