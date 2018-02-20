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
			<h2><a href='javascript:fetchPostList(${userId}, 0)'>카테고리</a></h2>
			<ul class="category-list"></ul>
		</div>
		
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
		
	</div>
</body>

<script type="text/javascript">
	$(document).ready(function(){
		var userId = ${userId};
		
		init(userId);
	});

	function init(userId){
		fetchPostList(userId, 0);
		fetchCategoryList(userId);
		getLogo(userId);		
	}
	
	function fetchPostList(userId, cateNo){ // getList
		$.ajax({
			url : "${pageContext.request.contextPath}/${userId}/api/getPostList",
			type : "post",
			data : {userId : userId, cateNo : cateNo},
			dataType : "json",
			success : function(pList){
				$(".blog-list").empty();
				
				if(pList.length == 0){
					$("#title").text("등록된 글이 없습니다.");
					$("#article-content").text("");
					}
				else{
					for(var i = 0; i < pList.length; i++) {
							render_postlist(pList[i]);
						}
		
						showPost(pList[0]);
					}
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	}
	
	function render_postlist(postVo){
		var str="";
		str += "<li>";
		str += "	<a href='javascript:getPost("+postVo.postNo+")'>"+postVo.postTitle+"</a>";
		str += "	<span>"+postVo.regDate+"</span>";
		str += "</li>";	

		$(".blog-list").append(str);
	}
	
	function showPost(postVo){ // show Post
		$("#title").text(postVo.postTitle);
		$("#article-content").text(postVo.postContent);
	}
	
	function getPost(postNo){ // get Post
		$.ajax({
			url : "${pageContext.request.contextPath}/${userId}/api/getPost",
			type : "post",
			data : {postNo : postNo},
			dataType : "json",
			success : function(postVo){
				if(postVo != null){
					showPost(postVo);
				}
				else{
					$("#title").text("등록된 글이 없습니다.");
					$("#article-content").text("");
				}
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	}
	
	function fetchCategoryList(userId){ // get Category list
		$.ajax({
			url : "${pageContext.request.contextPath}/${userId}/api/getCateList",
			type : "post",
			data : {userId : userId},
			dataType : "json",
			success : function(cList){
				for(var i = cList.length - 1; i >= 0; i--) {
					render_category(cList[i]);
				}
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	}
	
	function render_category(categoryVo){
		var str="";
		str += "<li>";
		str += "	<a href='javascript:fetchPostList(${userId}, "+categoryVo.cateNo+")'>"+categoryVo.cateName+"</a>";
		str += "</li>";	

		$(".category-list").append(str);
	}
	
	function getLogo(userId){ // get Logo url
		$.ajax({
			url : "${pageContext.request.contextPath}/${userId}/api/getLogo",
			type : "post",
			data : {userId : userId},
			dataType : "json",
			success : function(logoUrl){
 				$("img").attr("src","${pageContext.request.contextPath}/upload/"+logoUrl);
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	}
	
</script>
</html>