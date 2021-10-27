<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>사원 수정 페이지</h1>
<hr>

<h3>${map.ENAME } 사원 정보 수정</h3>

<form action="/dynamic/query3" method="post">

<input type="hidden" name="empno" value="${map.EMPNO }" />
<!-- 프라이머리키 수정은 안되게 하면서 서블릿에 값은 전달해줌 input type="hidden" -->

<label>직무 <input type="text" name="job" value="${map.JOB }" /></label><br>
<label>급여 <input type="text" name="sal" value="${map.SAL }" /></label><br>
<label>상여금 <input type="text" name="comm" value="${map.COMM }" /></label><br><br>

<button>수정</button>

</form>

</body>
</html>