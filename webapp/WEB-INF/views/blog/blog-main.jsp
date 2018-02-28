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
		
		<!-- *** Post *** -->
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4 id="title"></h4>
					<p id="article-content"><p>
					
					<br><br>
					<div class="comments">
						<h4 id="cmt-header">COMMENTS</h4>
						<c:if test = "${not empty authUser}">
							<table>
								<tr id="comment-form">
									<td>${authUser.userId}</td>
									<td><textarea rows="3" cols="80%" id="cmt-content"></textarea></td>
									<td><input type="button" value="저장" id="btn-add-cmt"></td>
								</tr>
							</table>
						</c:if>
													
						<table class="comment-list">
							<colgroup>
								<col width="10%">
								<col>
								<col width="20%">
 								<col width="5%">
							</colgroup>
							<tr id="comment-list"></tr>
						</table>
					</div> <!-- comments -->

					<br><br>
					<h4 id="post-list-header">POST LIST</h4>
					<ul class="blog-list"></ul>
					
				</div> <!-- blog-content -->				
			</div> <!-- content -->
		</div> <!-- wrapper -->


		<!-- *** Logo *** -->
		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}${logoUrl}">
			</div>
		</div>


		<!-- *** Category *** -->
		<div id="navigation">
			<h2><a href='javascript:fetchPostList(${userId}, 0)'>카테고리</a></h2>
			<ul class="category-list">
				<c:forEach items="${cList}" var="categoryVo" varStatus="status">
					<li>
						<a href='javascript:fetchPostList(${userId}, ${categoryVo.cateNo})'>${categoryVo.cateName}</a>
					</li>
				</c:forEach>
			</ul>
		</div>
		
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
		
	</div>
</body>

<script type="text/javascript">

	var curPostNo;
	
	$(document).ready(function(){
		var userId = ${userId};
		
		init(userId);
	});

	function init(userId){
		fetchPostList(userId, 0);
	}
	
	function fetchPostList(userId, cateNo){ // getList
		$("#comment-list").nextAll().remove();
		$("#post-list-header").show();
	
		$.ajax({
			url : "${pageContext.request.contextPath}/${userId}/api/getPostList",
			type : "post",
			data : {userId : userId, cateNo : cateNo},
			dataType : "json",
			success : function(pList){
				$(".blog-list").empty();
				
				if(pList.length == 0){
					noPost();
				} else{
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
		var content = postVo.postContent;
		$("#article-content").html(content);
		curPostNo = postVo.postNo;
		
		$("#comment-form").show();
		fetchCommentList(postVo.postNo);
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
					noPost();
				}
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	}
	
	function fetchCommentList(postNo){ // get Comment List
		$("#cmt-header").show();
		$("#comment-list").nextAll().remove();
	
		$.ajax({
			url : "${pageContext.request.contextPath}/${userId}/api/getCommentList",
			type : "post",
			data : {postNo : postNo},
			dataType : "json",
			success : function(cList){				
				for(var i = 0; i < cList.length; i++) {
					render_commentlist(cList[i]);
				}
				
				},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	}
	
 	function render_commentlist(cmtVo){
		var str="";
		str += "<tr id='cmt"+cmtVo.cmtNo+"' data-l = '5'>";
		str += "	<td>"+cmtVo.userId+"</td>";
		str += "	<td>"+cmtVo.cmtContent+"</td>";
		str += "	<td><span>"+cmtVo.regDate+"</span></td>";
		
		if(cmtVo.userNo == '${authUser.userNo}')
	 		str += "<td class='remove-cmt'>X</td>";
		else
			str += "<td></td>";

	 	str += "</tr>";

		$("#comment-list").after(str);
	}

	$("#btn-add-cmt").on("click", function(){ // Add Comment
		if(${authUser != null})
			var userId = ${authUser.userId} + "";
	
		var cmtUserNo = '${authUser.userNo}';
		var cmtContent = $("#cmt-content").val();

		$.ajax({
			url : "${pageContext.request.contextPath}/${userId}/api/addComment",
			type : "post",
			data : {postNo : curPostNo, cmtUserNo : cmtUserNo, cmtContent : cmtContent},
			dataType : "json",
			success : function(cmtVo){
				render_commentlist(cmtVo);
				$("#cmt-content").val("");
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});

	});
	
	function noPost(){
		$("#title").text("등록된 글이 없습니다.");
		$("#article-content").text("");
		
		$("#cmt-header").hide();
		$("#post-list-header").hide();
		$("#comment-form").hide();
	}
	
 	$(".comment-list").on("click", ".remove-cmt", function(){
		console.log($(this).closest('tr').attr('id'));
		
		/* $.ajax({
			url : "${pageContext.request.contextPath}/${userId}/api/removeComment",
			type : "post",
			data : {cmtNo : cmtNo},
			dataType : "json",
			success : function(cmtVo){
				render_commentlist(cmtVo);
				$("#cmt-content").val("");
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		}); */
	}); 
 	
	
</script>
</html>