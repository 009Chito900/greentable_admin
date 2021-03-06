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
$(function () {
	

	/* what i did  */



	$("#loginBtn").click(function(){

		chkNull(evt);

		
		
	});//click 
	

		$("#inputEmail").keydown(function(evt) {

			chkNull(evt);
		});
		$("#inputPassword").keydown(function(evt) {
			chkNull(evt);

		});
		
	
});//ready		

function chkNull(evt) {
	if (evt.which == 13 || evt.which == 9) {
		if ($("#inputEmail").val() == "") {
			alert("아이디 필수 입력");
			$("#inputEmail").focus();
			return;
		}
	}//end if
	if (evt.which == 13 ) {
		if ($("#inputPassword").val() == "") {
			alert("비밀번호 필수 입력");
			$("#inputPassword").focus();
			return;
		}
		$("#Login").submit();
	}//end if
}//chkPass


	/* what i did */

</script>

</head>

<body>
	<div id="wrapper">
		<div id="header">
	<img src="common/images/login.jpg">
		</div>
		<!-- header -->
		
		<div id="container">
		
		<div class="over">
			</div>
			  
			<div class="login-box">
				<h2>Admin Login</h2>
		
					<form id="Login" action="login_process.do" method="post">
				<input type="hidden" id="user_id"  value="${sessionScope.user_id }" />

				<div class="user-box">
			<input type="text" name="id" class="inputBox" required="required" autofocus="autofocus" id="inputEmail" > <label>아이디</label>
				</div>
				
				<div class="user-box">
				<input onkeyup="enterkey();" type="password" name="password" class="inputBox" required="required" id="inputPassword" ><label>비밀번호</label>

					</div>
					<a id="loginBtn" > <span></span>
						<span></span> <span></span> <span></span> 로그인
					</a> 
					</form>
				</div>
			<!-- login-box -->				
		</div>
		<!-- container -->

		<div id="footer">
		
		</div>
		<!-- footer -->
	</div>
</body>
</html>