<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<!-- 스마트 에디터 2 라이브러리 로드 -->
<script type="text/javascript" src="/resources/se2/js/service/HuskyEZCreator.js"></script>

<script type="text/javascript">
function submitContents(elClickedObj) {
	oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
	
	try {
		elClickedObj.form.submit();
	} catch(e) {}
}

$(document).ready(function() {
	$("#btnWrite").click(function() {
		submitContents($("#btnWrite"));
		
		$("form").submit();
	})
	
	$("#cancel").click(function() {
		history.go(-1);
	})
})
</script>

<div class="container">

<h1>게시글 수정하기</h1>
<hr>

<form action="/board/update" method="post" enctype="multipart/form-data">
<div class="form-group">
	<label for="write">작성자</label>
	<input type="text" id="write" value="${nick }" class="form-control" readonly="readonly"/>
</div>
<div class="form-group">
	<label for="title">제목</label>
	<input type="text" id="title" name="title"  value="${updateBoard.title }" class="form-control"/>
</div>
<div class="form-group">
	<label for="content">본문</label>
	<textarea rows="10" style="width: 100%;" id="content" name="content">${updateBoard.content }</textarea>
</div>

<div style="text-align: left;">
	<div id="beforeFile">
		<c:if test="${!empty boardfile}">
		기존 파일 : 
		<a href="/upload/${boardfile.storedName }" download="${boardfile.originName }">${boardfile.originName }</a>
		<span id="delFile" style="color: red; font: bold; cursor: pointer;">x</span>
		</c:if>
		<c:if test="${empty boardfile}">
		첨부파일이 없습니다.
		</c:if>
	</div>
	<br>
	<div id="afterFile">
		<input type="file" name="file" />
		<input type="hidden" name="fileDelete" id="fileDelete" value=""/>
	</div>
</div>

<div class="text-center">
	<button class="btn btn-primary" id="btnUpdate">수정하기</button>
	<input type="reset" id="cancel" class="btn btn-danger" value="취소"/>
</div>
</form>

<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "content",
	sSkinURI: "/resources/se2/SmartEditor2Skin.html",
	fCreator: "createSEditor2"
});
</script>

</div><!-- .container -->

<c:import url="/WEB-INF/views/layout/footer.jsp" />













