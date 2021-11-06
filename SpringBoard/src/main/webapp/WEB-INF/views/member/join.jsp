<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<div class="container">

<h1>회원가입</h1>
<hr>

<form action="/member/join" method="post">
아이디 <input type="text" name="id" /><br>
비밀번호 <input type="text" name="pw" /><br>
닉네임 <input type="text" name="nick" /><br>
<button>회원가입</button>
</form>

</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />