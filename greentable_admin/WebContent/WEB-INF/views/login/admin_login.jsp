<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	info="로그인 페이지"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="common/css/login.css">
<style type="text/css">
img {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
}

.over {
	position: absolute;
	top: 0px;
	width: 100%;
	height: 100%;
	background: #000000;
	opacity: 0.3;
}
</style>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<script type="text/javascript">

</script>

</head>
<body>
	<div id="wrapper">

		<div id="header">

		</div>

		<div id="container">
		
			<div class="wrap">
			
				<img src="http://localhost/final_prj/common/images/login.jpg">
			</div> 
			
			 <div class="over">
			</div>
			  
			 <div class="login-box">
				<h2>Admin Login</h2>
				<form name="loginFrm" action="member_login.jsp" id="loginFrm" method="post">
					<div class="user-box">
						<input type="text" name="email" id="email" class="inputBox"
							required="required" autofocus="autofocus"> <label>아이디</label>
					</div>
					
					<div class="user-box">
						<input type="password" name="pass" id="pass" class="inputBox"
							required="required"> <label>비밀번호</label>
					</div>
					
					<a id="loginBtn" href="#void"> <span></span>
						<span></span> <span></span> <span></span> 로그인
					</a> 
				</form>
			</div>

		</div>

		<div id="footer">
		</div>
		
	</div>
</body>
</html>

