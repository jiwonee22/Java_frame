<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원가입</h1>
<hr>

<form action="/login/join" method="post">
아이디 <input type="text" name="id" /><br>
비밀번호 <input type="text" name="pw" /><br>
이메일 <input type="text" name="email" /><br>
전화번호 <input type="text" name="phone" /><br>
<button>회원가입</button>
</form>

</body>
</html>