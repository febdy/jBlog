<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>JBlog</title>
<link rel="stylesheet" href="/jblog/assets/css/jblog.css">
</head>
<body>
	<div class="center-content">
		
	<c:import url="/WEB-INF/views/includes/header.jsp"/>
		
		<form class="login-form" method="post" action="${pageContext.request.contextPath}/user/login">
      		<label>아이디</label> 
      		<input type="text" name="id">
      		
      		<label>패스워드</label> 
      		<input type="password" name="password">
      		
      		<p class="form-error">
				<c:if test="${param.loginfail == true}">
				로그인 실패<br>
				아이디/패스워드를 확인해주세요.
				</c:if>
			</p>
      		<input type="submit" value="로그인">
		</form>
		
	</div>
	<div id="dialog-message" title="" style="display:none">
  		<p></p>
	</div>
</body>

</html>