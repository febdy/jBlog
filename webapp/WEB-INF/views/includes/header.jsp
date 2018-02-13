<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<<<<<<< HEAD
<a href="${pageContext.request.contextPath}/main"><img class="logo"
	src="${pageContext.request.contextPath}/assets/images/logo.jpg"></a>
<ul class="menu">

	<c:if test="${empty authUser}">
		<li><a href="${pageContext.request.contextPath}/user/loginform">로그인</a></li>
		<li><a href="${pageContext.request.contextPath}/user/joinform">회원가입</a></li>
	</c:if>
	<c:if test="${not empty authUser}">
		<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
		<li><a
			href="${pageContext.request.contextPath}/user/${authUser.userNo}">내블로그</a></li>
	</c:if>
=======
<a href=""> <img class="logo" src="${pageContext.request.contextPath}/assets/images/logo.jpg"></a>
<ul class="menu">

	<!-- 로그인 전 메뉴 -->
	<li><a href="">로그인</a></li>
	<li><a href="${pageContext.request.contextPath}/user/joinform">회원가입</a></li>

	<!-- 로그인 후 메뉴 -->
	<!-- <li><a href="">로그아웃</a></li>
	<li><a href="">내블로그</a></li> -->
>>>>>>> 8a3360a9c7f5d24f2163034f0dfcfd97fa13969d

</ul>