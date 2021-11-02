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

<h1>마이페이지</h1>
<hr>

아이디 :  ${info.id }<br>
패스워드 :  ${info.pw }<br>
이메일 :  ${info.email }<br>
전화번호 :  ${info.phone }<br>

<a href="/login/main"><button>메인</button></a>

</body>
</html>