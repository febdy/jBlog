<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="/jblog/assets/css/jblog.css">
</head>
<body>
	<div class="center-content">
		
		<!-- 메인해더 -->
		<a href="">
			<img class="logo" src="/jblog/assets/images/logo.jpg">
		</a>
		<ul class="menu">
			
			<!-- 로그인 전 메뉴 -->
			<li><a href="">로그인</a></li>
			<li><a href="">회원가입</a></li>
		
			<!-- 로그인 후 메뉴 -->
			<!-- <li><a href="">로그아웃</a></li>
			<li><a href="">내블로그</a></li> -->
				
 		</ul>
 		<!-- /메인해더 -->
		
		<form class="login-form" method="" action="">
      		<label>아이디</label> 
      		<input type="text" name="id">
      		
      		<label>패스워드</label> 
      		<input type="text" name="password">
      		
      		<p class="form-error">
				에러메세지
			</p>
      		<input type="submit" value="로그인">
		</form>
		
	</div>
	<div id="dialog-message" title="" style="display:none">
  		<p></p>
	</div>
</body>
</html>