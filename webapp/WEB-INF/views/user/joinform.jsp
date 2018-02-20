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
	<div class="center-content">
		
	<c:import url="/WEB-INF/views/includes/header.jsp"/>
 		
		<form class="join-form" id="join-form" method="post" action="${pageContext.request.contextPath}/user/join">
			<label class="block-label" for="name">이름</label>
			<input type="text" name="userName"  value="" />
			<div class="form-error" id="error-name"><br></div>
			
			<label class="block-label" for="id">아이디</label>
			<input type="text" name="userId"  value="" />
			<input id="btn-checkid" type="button" value="id 중복체크">
			<img id="img-checkid" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">
			<div class="form-error" id="error-id"><br></div>

			<label class="block-label" for="password">패스워드</label>
			<input type="password" name="password"  value="" />
			<div class="form-error" id="error-password"><br></div>
			
			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>
			<div class="form-error" id="error-agree"><br></div>
			
			<input type="submit" value="가입하기">
		</form>
	</div>

</body>

<script type="text/javascript">

	var idCheck = false;
	var idOk = false;

	$("#btn-checkid").on("click", function(){		
		$.ajax({
			url : "${pageContext.request.contextPath}/api/users/checkId",
			type : "post",
			data : {userId : $("[name=userId]").val()},
			dataType : "json",
			success : function(result){
				idCheck = true;
				
				if(result == -1){
					$("#error-id").text("아이디를 입력해주세요.");
					idOk = false;
				} else if(result != 0){
					$("#error-id").html("<font color='red'>다른 아이디로 가입해 주세요.</font>");
					idOk = false;
				} else{
					$("#error-id").text("사용할 수 있는 아이디입니다.");
					idOk = true;
				}
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	});
	
	$("form").on("submit", function(){
		var name = $("[name=userName]");
		var userId = $("[name=userId]");
		var password = $("[name=password]");
		var agreeProv = $("[name=agreeProv]");
		
		makeErrorEmpty();
		
		if(name.val() == ""){
			$("#error-name").html("<font color='red'>이름을 입력해주세요.</font>");
			name.focus();
			return false;
		}
		
		if(idCheck != true){
			$("#error-id").html("<font color='red'>아이디 중복 확인을 해주세요.</font>");
			userId.focus();
			return false;
		} 
		
		if(idOk != true){
			$("#error-id").html("<font color='red'>다른 아이디로 가입해 주세요.</font>");
			userId.focus();
			return false;
		}
		
		if(password.val() == ""){
			$("#error-password").html("<font color='red'>비밀번호를 입력해주세요.</font>");
			password.focus();
			return false;
		}
		
		if(agreeProv[0].checked == false){
			$("#error-agree").html("<font color='red'>약관에 동의해주세요.</font>");
			agreeProv.focus();
			return false;
		}

	});

	function makeErrorEmpty(){
		$("#error-name").html("<br>");
		$("#error-id").html("<br>");
		$("#error-password").html("<br>");
		$("#error-agree").html("<br>");
	}
	
</script>

</html>