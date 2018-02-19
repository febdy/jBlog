<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="header">
	<h1>블로그타이틀 출력해야함</h1>
	<ul>
		<!-- 로그인 전 메뉴 -->
		<c:if test="${empty authUser}">
			<li><a href="${pageContext.request.contextPath}/user/loginform">로그인</a></li>
		</c:if>

		<c:if test="${not empty authUser}">
			<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
			
			<c:if test="${authUser.userId eq userId}">
				<li><a href="${pageContext.request.contextPath}/${authUser.userId}/admin/basic">내블로그 관리</a></li>
			</c:if>

		</c:if>
	</ul>
</div>