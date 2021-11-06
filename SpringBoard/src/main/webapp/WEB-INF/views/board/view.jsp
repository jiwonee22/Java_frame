<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<body>

<div class="container">


<table class="table table-striped table-hover">
<thead>
	<tr>
		<th style="width: 10%;">글번호</th>
		<th style="width: 45%;">제목</th>
		<th style="width: 20%;">작성자</th>
		<th style="width: 10%;">조회수</th>
		<th style="width: 15%;">작성일</th>
	</tr>
</thead>
<tbody>
	<tr>
		<td style="width: 10%;">${board.boardNo }</td>
		<td style="width: 45%;">${board.title }</td>
		<td style="width: 20%;">${board.writerNick }</td>
		<td style="width: 10%;">${board.hit }</td>
		<td style="width: 15%;">${board.writeDate }</td>
	</tr>
	<tr>
		<td colspan="5">${board.content }</td>
	</tr>
</tbody>
</table>



</div><!-- .container -->

<c:import url="/WEB-INF/views/layout/footer.jsp" />
