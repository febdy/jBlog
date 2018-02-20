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
			url : "${pageContext.request.contextPath}/${authUser.userId}/api/admin/getCategory",
			type : "post",
			data : {userNo : userNo},
			dataType : "json",
			success : function(cList){
				for(var i = cList.length-1; 0 <= i; i--) {
					var num = cList.length - i;
					render(cList[i], num);
				}
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	}
	
	function render(categoryVo, num){
		var str="";
		str += "<tr id=\"tr"+categoryVo.cateNo+"\">";
		str += "	<th>"+num+"</th>";
		str += "	<th>"+categoryVo.cateName+"</th>";
		str += "	<th>"+categoryVo.postCnt+"</th>";
		str += "	<th>"+categoryVo.description+"</th>";
		str += "	<th><img src=\"${pageContext.request.contextPath}/assets/images/delete.jpg\" class=\"delete\" id=\""+categoryVo.cateNo+"\"></th>";
		str += "</tr>";
		
		$("#bar").after(str);

	}
	
	$("input[type=submit]").on("click", function(){ // add category	
		var categoryVo = {
				'userNo' : ${authUser.userNo},
				'cateName' : $("[name=name]").val(),
				'description' : $("[name=desc]").val()
		}
		
		$.ajax({
			url : "${pageContext.request.contextPath}/${authUser.userId}/api/admin/addCategory",
			type : "post",
			data : JSON.stringify(categoryVo),
			contentType : "application/json; charset=UTF-8",

			dataType : "json",
			success : function(map){
				render(map.categoryVo, map.cnt);
				$("[name=name]").val("");
				$("[name=desc]").val("");
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	});
	
	$(".admin-cat").on("click", ".delete", function(){ // delete category
	
		var idNum = this.id;
		
		$.ajax({
			url : "${pageContext.request.contextPath}/${authUser.userId}/api/admin/deleteCategory",
			type : "post",
			data : {cateNo : idNum},
			//contentType : "application/json; charset=UTF-8",

			dataType : "json",
			success : function(result){
				if(result == -1){
					alert("삭제할 수 없습니다.");
				} else {
					$("#tr"+idNum).remove();
				}
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	});	
	
</script>

</html>