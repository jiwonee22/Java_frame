<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>맵을 이용한 파라미터 처리 폼</h1>
<hr>

<form action="/param/map" method="post">
데이터1 <input type="text" name="data1" value="a" /><br>
데이터2 <input type="text" name="data2" value="b" /><br>
데이터3 <input type="text" name="data3" value="c" /><br>
데이터4 <input type="text" name="data4" value="d" /><br>
이름 <input type="text" name="name" value="1" /><br>
나이 <input type="text" name="age" value="2" /><br><br>

<button>전송</button>
</form>

</body>
</html>