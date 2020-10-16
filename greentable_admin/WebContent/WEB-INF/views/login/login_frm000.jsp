<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	info="관리자 로그인 페이지"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title> 

<!-- 다음 우편 번호 API -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- Google CDN -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<!-- CSS -->
<link rel="stylesheet" type="text/css" href="common/css/admin-login.css">

<style type="text/css">
img {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
}

/* 이미지 위에 어둡게 처리 */
.over {
	position: absolute;
	top: 0px;
	width: 100%;
	height: 100%;
	background: #000000;
	opacity: 0.3;
}
</style>

<script type="text/javascript">
$(function(){
    
});//ready

function chkNull(){
	
	 if($("#inputEmail").val() =="" || $("#inputPassword").val()=="" ){
	
		alert("아이디와 패스워드를 입력해주세요");//Please eneter ID,pass
	
		location.href='login_frm.do';
	}else{
		
		$("#Login").submit();
	}
		

	
}//chkNull

</script>

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<img src="http://localhost/design_prj/common/images/login.jpg">
		</div>
		<!-- header -->
		
		<div id="container">
		
			<div class="over">
			</div>
			  
	<form id="Login" action="login_process.do" method="post">
					
	<input type="hidden" id="user_id"  value="${sessionScope.user_id }" />
				
			<div class="login-box">
				<h2>Admin Login</h2>
				<form name="loginFrm" action="member_login.jsp" id="loginFrm" method="post">
					<div class="user-box">
						<input type="text" name="id" class="form-control" id="inputEmail" placeholder="아이디를 입력해주세요"><label>아이디</label>
					</div>
					<div class="user-box">
							<input onkeyup="enterkey();" type="password" name="password" class="form-control" id="inputPassword" placeholder="비밀번호를 입력해주세요"> <label>비밀번호</label>
					</div>
					<button type="button" class="btn btn-primary" id="loginBtn" > <span></span>
						<span></span> <span></span> <span></span> 로그인
					</a> 
				</form>
			</div>
			<!-- login-box -->
		</div>
		<!-- container -->

		<div id="footer"></div>
		<!-- footer -->
		
	</div>
</body>
</html>
