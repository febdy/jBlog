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
				
		      	<table class="admin-cat">
			      	<tr id="bar">
						<th>번호</th>
						<th>카테고리명</th>
						<th>포스트 수</th>
						<th>설명</th>
						<th>삭제</th>
					</tr>
				</table>

      			<h4 class="n-c">새로운 카테고리 추가</h4>
		      	<table id="admin-cat-add">
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" name="name"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" name="desc"></td>
		      		</tr>
		      		<tr>
		      			<td class="s">&nbsp;</td>
		      			<td><input type="submit" value="카테고리 추가"></td>
		      		</tr>      		      		
		      	</table> 
			</div>
		</div>

		<c:import url="/WEB-INF/views/includes/footer.jsp" />
		
	</div>
</body>
<script type="text/javascript">
	
	$(document).ready(function(){
		var userNo = ${authUser.userNo};
		fetchList(userNo);
	});
	
	function fetchList(userNo){ // getList
		$.ajax({
			url : "${pageContext.request.contextPath}/${authUser.userId}/api/admin/category",
			type : "post",
			data : {userNo : userNo},
			dataType : "json",
			success : function(cList){
				for(var i = 0; i < cList.length; i++) {
					cList[i].cateNo = cList.length - i;
					render(cList[i], "down");
				}
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	}
	
	function render(categoryVo, updown){
		var str="";
		str += "<tr>";
		str += "	<th>"+categoryVo.cateNo+"</th>";
		str += "	<th>"+categoryVo.cateName+"</th>";
		str += "	<th>"+"포스트 수"+"</th>";
		str += "	<th>"+categoryVo.description+"</th>";
		str += "	<th><img src=\"${pageContext.request.contextPath}/assets/images/delete.jpg\"></th>";
		str += "</tr>";
		
		if(updown == "up")
			$(str).insertAfter("#bar");
		else if(updown == "down")
			$(".admin-cat").append(str);
		else
			console.log("updown 오류");
	}
	
	$("input[type=submit]").on("click", function(){ // add category	
		var categoryVo = {
				'userNo' : ${authUser.userNo},
				'cateName' : $("[name=name]").val(),
				'description' : $("[name=desc]").val()
		}
		
		$.ajax({
			url : "${pageContext.request.contextPath}/${authUser.userId}/api/admin/categoryAdd",
			type : "post",
			data : JSON.stringify(categoryVo),
			contentType : "application/json; charset=UTF-8",

			dataType : "json",
			success : function(categoryVo){
				render(categoryVo, "up");
				$("[name=name]").val("");
				$("[name=desc]").val("");
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	});
	
</script>

</html>