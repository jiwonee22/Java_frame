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
			, url: "/ajax/test02_ok"
			, data: {}
			, dataType: "json"
			, success: function(res) {
				console.log("AJAX 성공")
				
				//응답 데이터 확인
				console.log(res)
			}
			, error: function() {
				console.log("AJAX 실패")
			}
		})
	})
});
</script>

</head>
<body>

<h1>AJAX 테스트 02</h1>
<h3>@ResponseBody를 이용한 JSON Text 응답</h3>
<hr>

<button id="ajax">AJAX요청 보내기</button>

</body>
</html>