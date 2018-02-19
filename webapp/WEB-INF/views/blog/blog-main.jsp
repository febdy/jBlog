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
			<div id="content">
				<div class="blog-content">
					<h4 id="title"></h4>
					<p id="article-content"><p>
				</div>
				<ul class="blog-list">
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="/jblog/assets/images/spring-logo.jpg">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<li><a href="">닥치고 스프링</a></li>
				<li><a href="">스프링 스터디</a></li>
				<li><a href="">스프링 프로젝트</a></li>
				<li><a href="">기타</a></li>
			</ul>
		</div>
		
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
		
	</div>
</body>

<script type="text/javascript">
	$(document).ready(function(){
		var userId = ${userId};
		fetchPostList(userId);
	});
	
	function fetchPostList(userId){ // getList
		$.ajax({
			url : "${pageContext.request.contextPath}/${userId}/api/getPostList",
			type : "post",
			data : {userId : userId},
			dataType : "json",
			success : function(pList){
				for(var i = 0; i < pList.length; i++) {
					render(pList[i]);
				}

				showFirstArticle(pList[0]);
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});

	}
	
	function render(postVo){
		var str="";
		str += "<li>";
		str += "	<a href=\"\">"+postVo.postTitle+"</a>";
		str += "	<span>"+postVo.regDate+"</span>";
		str += "</li>";	

		$(".blog-list").append(str);
		
	}
	
	function showFirstArticle(postVo){ // show First Article
		$("#title").text(postVo.postTitle);
		$("#article-content").text(postVo.postContent);
	}
	
</script>
</html>