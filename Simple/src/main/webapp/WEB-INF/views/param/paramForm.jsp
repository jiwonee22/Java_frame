<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>파라미터 전달 폼</h1>
<hr>

<form action="/param/requestParam" method="post">

<label>이름 <input type="text" name="username" /></label><br>
<label>나이 <input type="text" name="userage" /></label><br><br>

<button>전송</button>

</form>


</body>
</html>