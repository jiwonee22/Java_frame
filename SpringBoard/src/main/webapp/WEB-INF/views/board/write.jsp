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

<h3>게시글 작성 페이지</h3>
<hr>

<form action="/board/write" method="post">
<table class="table table-striped table-hover">
<thead>
	<tr>
		<th style="width: 100%;">제목</th>
	</tr>
</thead>
<tbody>
	<tr>
		<td style="width: 100%;"><input type="text" name="title" class="title" style="width: 100%;"/></td>
	</tr>
	<tr>
		<th style="width: 100%;">내용</th>
	</tr>
	<tr>
		<td colspan="5"><textarea name="content" id="content" class="content" style="width: 100%; height: 400px;" ></textarea></td>
	</tr>
</tbody>
</table>

<button>작성</button>
<button>취소</button>
</form>


</div><!-- .container -->

<c:import url="/WEB-INF/views/layout/footer.jsp" />

