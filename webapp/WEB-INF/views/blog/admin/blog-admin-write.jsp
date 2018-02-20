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
				
				<form action="${pageContext.request.contextPath}/${authUser.userId}/admin/write" method="post">
			      	<table class="admin-cat-write">
			      		<tr>
			      			<td class="t">제목</td>
			      			<td>
			      				<input type="text" size="60" name="title">
				      			<select name="category"></select>
				      		</td>
			      		</tr>
			      		<tr>
			      			<td class="t">내용</td>
			      			<td><textarea name="content"></textarea></td>
			      		</tr>
			      		<tr>
			      			<td>&nbsp;</td>
			      			<td class="s"><input type="submit" value="포스트하기"></td>
			      		</tr>
			      	</table>
				</form>
			</div>
		</div>
		
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
		
	</div>
</body>

<script type="text/javascript">

	$(document).ready(function(){
		var userNo = ${authUser.userNo};
		fetchCateList(userNo);
	});
	
	function fetchCateList(userNo){ // make category list
		$.ajax({
			url : "${pageContext.request.contextPath}/${authUser.userId}/api/admin/getCategory",
			type : "post",
			data : {userNo : userNo},
			dataType : "json",
			success : function(cList){
				for(var i = 0; i < cList.length; i++) {
					render(cList[i]);
				}
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});	
	}
	
	function render(categoryVo){
		var str="";
		str += "<option value="+categoryVo.cateNo+">"+categoryVo.cateName+"</option>";
		
		$("[name=category]").append(str);
	}
	
</script>
</html>