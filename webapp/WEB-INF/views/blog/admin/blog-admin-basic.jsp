<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>

<title>JBlog</title>
<link rel="stylesheet" href="/jblog/assets/css/jblog.css">
</head>
<body>

	<div id="container">
		
		<c:import url="/WEB-INF/views/includes/blog-header.jsp" />
		
		<div id="wrapper">
			<div id="content" class="full-screen">
			
				<c:import url="/WEB-INF/views/includes/admin-menu.jsp" />
				
				<form action="${pageContext.request.contextPath}/${authUser.userId}/admin/basicupdate" method="post" enctype="multipart/form-data">
	 		      	<table class="admin-config">
			      		<tr>
			      			<td class="t">블로그 제목</td>
			      			<td><input type="text" size="40" name="title" value="${blogVo.blogTitle}"></td>
			      		</tr>
			      		<tr>
			      			<td class="t">로고이미지</td>
			      			<c:if test="${empty blogVo.logoFile}">
			      				<td><img src="/jblog/assets/images/spring-logo.jpg"></td>
			      			</c:if>
			      			<c:if test="${not empty blogVo.logoFile}">
				      			<td><img src="${pageContext.request.contextPath}/upload/${blogVo.logoFile}" style="width:150px"></td>
				      		</c:if>
			      		</tr>      		
			      		<tr>
			      			<td class="t">&nbsp;</td>
			      			<td><input type="file" name="logo-file" onchange="readURL(this)"></td>
			      		</tr>           		
			      		<tr>
			      			<td class="t">&nbsp;</td>
			      			<td class="s"><input type="submit" value="기본설정 변경"></td>      			
			      		</tr>           		
			      	</table>
				</form>
			</div>
		</div>
		
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	
	</div>
</body>

<script type="text/javascript">

	function readURL(input) { 
		if (input.files && input.files[0]) { 
			var reader = new FileReader(); 
	
			reader.onload = function (e) { 
				$("img").attr('src', e.target.result); 
			}
			
			reader.readAsDataURL(input.files[0]); 
		} 
	}
	
</script>
</html>