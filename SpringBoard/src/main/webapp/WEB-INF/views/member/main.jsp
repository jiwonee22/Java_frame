<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<h1>메인 화면</h1>
<hr>

<%-- 비로그인 상태 --%>
<c:if test="${empty login }">
<a href="/member/login"><button>로그인</button></a>
<a href="/member/join"><button>회원가입</button></a>
</c:if>

<%-- 로그인 상태 --%>
<%-- <c:if test="${not empty login }"> --%>
<c:if test="${login }">
<a href="/member/logout"><button>로그아웃</button></a>
<a href="/board/list"><button>게시판으로 이동</button></a>
</c:if>

<c:import url="/WEB-INF/views/layout/footer.jsp" />
