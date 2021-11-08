<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<style type="text/css">

table {
	table-layout: fixed;
}

table, th {
	text-align: center;
}

</style>

<div class="container">

<h3>게시글 목록</h3>
<hr>

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
<c:forEach items="${boardList }" var="board">
	<tr>
		<td>${board.boardNo }</td>
		<td><a href="/board/view?boardno=${board.boardNo }">${board.title }</a></td>
		<td>${board.writerNick }</td>
		<td>${board.hit }</td>
		<td><fmt:formatDate value="${board.writeDate }" pattern="yy-MM-dd HH:mm:ss"/></td>
	</tr>
</c:forEach>
</tbody>
</table>

<%-- 로그인 상태 --%>
<%-- <c:if test="${not empty login }"> --%>
<c:if test="${login }">
<span class="pull-left"><a href="/board/write"><button>작성하기</button></a></span>
</c:if>


<c:if test="${empty login }">
<span class="pull-left"><a href="/member/login"><button>로그인</button></a></span>
</c:if>

<span class="pull-right">total : ${paging.totalCount }</span>
<div class="clearfix"></div>

<c:import url="/WEB-INF/views/layout/paging.jsp" />

</div><!-- .container -->

<c:import url="/WEB-INF/views/layout/footer.jsp" />

