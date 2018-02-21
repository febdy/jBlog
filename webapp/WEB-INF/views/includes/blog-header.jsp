<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="header">
	<h1 id="header-title"></h1>
	<ul>
		<!-- 로그인 전 메뉴 -->
		<c:if test="${empty authUser}">
			<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
		</c:if>

		<c:if test="${not empty authUser}">
			<li><a href="${pageContext.request.contextPath}/user/logout?userId=${userId}">로그아웃</a></li>
			
			<c:if test="${authUser.userId eq userId}">
				<li><a href="${pageContext.request.contextPath}/${authUser.userId}/admin/basic">내블로그 관리</a></li>
			</c:if>

		</c:if>
	</ul>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		var userId = ${userId};
		getTitle(userId);
	});
	
	function getTitle(userId){
		$.ajax({
			url : "${pageContext.request.contextPath}/${userId}/api/getTitle",
			type : "post",
			data : {userId : userId},
			dataType : "json",
			success : function(result){
				$("#header-title").html("<a href='${pageContext.request.contextPath}/${userId}'>"+result+"</a>");
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	}
</script>