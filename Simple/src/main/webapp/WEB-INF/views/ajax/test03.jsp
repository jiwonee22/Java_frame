<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	$("#ajax").click(function() {
		console.log("#ajax clicked")
		
		$.ajax({
			type: "get"
			, url: "/ajax/test03_ok"
			, data: {}
			, dataType: "html"
			, success: function(res) {
				console.log("AJAX 성공")
				
				$("#resultLayout").html(res)
			}
			,  error: function() {
				console.log("AJAX 실패")
			}
		})
	})
});
</script>

</head>
<body>

<h1>AJAX 테스트 03</h1>
<h3>JSP를 이용한 HTML 응답</h3>
<hr>

<button id="ajax">AJAX요청 보내기</button>
<hr>

<div id="resultLayout"></div>

</body>
</html>