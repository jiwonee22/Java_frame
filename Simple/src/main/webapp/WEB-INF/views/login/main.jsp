<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>메인화면</h1>
<hr>

<%-- 비로그인 상태 --%>
<c:if test="${empty login }">
<a href="<%=request.getContextPath() %>/login/login"><button>로그인</button></a>
<a href="<%=request.getContextPath() %>/login/join"><button>회원가입</button></a>
</c:if>

<%-- 로그인 상태 --%>
<c:if test="${login }">
<a href="<%=request.getContextPath() %>/login/mypage"><button>마이페이지</button></a>
<a href="<%=request.getContextPath() %>/login/logout"><button>로그아웃</button></a>
</c:if>

</body>
</html>          