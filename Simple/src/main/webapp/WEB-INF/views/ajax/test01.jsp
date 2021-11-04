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
			type: "get" //요청 메소드
			, url: "/ajax/test01_ok" //요청 URL
			, data: {} //요청 파라미터
			, dataType: "json" //응답받을 데이터의 형식, 유형
			, success: function(res) { //AJAX 성공시 콜백함수
				console.log("AJAX 성공")
				
				//응답 데이터 확인
				console.log(res)
				
				//데이터 사용
				console.log(res.result)
				
			}
			, error: function() { //AJAX 실패시 콜백함수
				console.log("AJAX 실패")
				
			}
		})
	})	
});
</script>

</head>
<body>

<h1>AJAX 테스트 01</h1>
<hr>

<button id="ajax">AJAX요청 보내기</button>

</body>
</html>