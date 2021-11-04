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
			, url: "/ajax/test04_ok"
			, data: {}
			, dataType: "json"
			, success: function(res) {
				console.log("AJAX 성공")
				
				console.log(res)

				console.log(res.rd)

				//필요한 데이터 이용
				console.log(res.rd.data1)
				console.log(res.rd.data2)
				console.log(res.rd.data3)
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

<h1>AJAX 테스트 04</h1>
<h3>jsonView를 이용한 JSON text 응답</h3>
<hr>

<button id="ajax">AJAX요청 보내기</button>

</body>
</html>