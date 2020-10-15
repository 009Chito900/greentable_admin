<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	info="관리자 회원관리 페이지"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 회원관리 수정</title>

<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<!-- 다음 우편 번호 API -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- Google CDN -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<!-- CSS -->
<link rel="stylesheet" type="text/css" href="http://localhost/greentable_admin/common/css/admin-header.css">

<style>
#wrap {
	width: 1300px;
	height: 930px;
	margin: 0px auto;
}

#header { 
	width: 100%;
	margin: 0px auto;
}

#container {
	position: relative;
	width: 1300px;
	min-height: 500px;
	margin: 0px auto;
	margin-top: 80px;
}

#footer {
	width: 100%;
	padding: 20px;
	position: relative;
	text-align: center;
	height: 100px;
	background-color: #F6F6F6;
	margin-top: 100px;
}

h2 {
	text-align: center;
	font-weight: bold;
}

#memberDiv {
	width: 500px;
	margin-top: 30px;
	margin-left: 400px;  
}

#span {
	font-size: 17px;
	font-weight: bold;
	background-color: #F6F6F6;
}
.form-control {
	font-size: 17px;  
}
</style>
<script type="text/javascript">
$(function(){
	
	//우편번호 검색
	$("[value='우편번호 찾기']").click(function() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
	            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	            var roadAddr = data.roadAddress; // 도로명 주소 변수
	            var extraRoadAddr = ''; // 참고 항목 변수
	
	            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                extraRoadAddr += data.bname;
	            }
	            // 건물명이 있고, 공동주택일 경우 추가한다.
	            if(data.buildingName !== '' && data.apartment === 'Y'){
	               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	            }
	            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	            if(extraRoadAddr !== ''){
	                extraRoadAddr = ' (' + extraRoadAddr + ')';
	            }
	
	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
	            $("#zipcode").val(data.zonecode);
	            $("#addr1").val(roadAddr);
	            
	        }
	    }).open();
		
	});//click
	
	//요청하는 do를 변경
	$("#upd").click(function() {
		if (confirm("회원을 수정하시겠습니까?")) {
			//form태그의 action속성을 변경, document.폼이름.action = "변경할액션"
			document.frm.action = "modify_member.do";
			$("[name='frm']").submit(); //HTML Form Control의 값이 POST방식으로 전달.
		}
	});//click

	//요청하는 do를 변경
	$("#del").click(function() {
		if (confirm("회원을 삭제하시겠습니까?")) {
			//form태그의 action속성을 변경, document.폼이름.action = "변경할액션"
			document.frm.action = "remove_member.do";
			//document.frm.enctype = "application/x-www.form-urlencoded"; //파라메터 전송방식으로 변경
			$("[name='frm']").submit();
		}
	});//click
 
});//ready
</script>

</head>
<body>
	<div id="wrapper">
		<div id="header">
 			<div id="naviBar">
				<c:import url="/common/jsp/admin-header.jsp" />
			</div>
		</div>
		<!-- header -->
 
		<div id="container">
			
			<div id="memberDivWrap">
				<h2>회원관리</h2>
				<hr style="width: 800px">
				<div id="memberDiv">
					<form method="post" name="frm">
						
						<div class="input-group mb-3 input-group-lg">
							<div class="input-group-prepend">
								<span class="input-group-text" id="span" style="width: 90px">아이디</span>
							</div>
							<input type="text" class="form-control" id="id" name="id" value="${data.id }" readonly="readonly" style="font-size: 17px">
						</div>
	
						<div class="input-group mb-3 input-group-lg">
							<div class="input-group-prepend">
								<span class="input-group-text" id="span" style="width: 90px">이메일</span>
							</div>
							<input type="email" class="form-control" id="email" name="email" value="${data.email }" style="font-size: 17px">
						</div>
	
						<div class="input-group mb-3 input-group-lg"> 
							<div class="input-group-prepend">
								<span class="input-group-text" id="span" style="width: 90px">주소</span> 
							</div>
							<input type="text" class="form-control" id="zipcode" name="zipcode" value="${data.zipcode }"style="font-size: 17px">
							<input type="button" class="btn btn-outline-info" value="우편번호 찾기" style="font-size: 17px"/> 
						</div>
	
						<div class="input-group mb-3 input-group-lg" style="width: 410px; margin-left: 90px">  
							<input type="text" class="form-control" id="addr1" name="addr1" value="${data.addr1 }" style="font-size: 17px">
						</div>			
						
						<div class="input-group mb-3 input-group-lg">
							<div class="input-group-prepend">
								<span class="input-group-text" id="span">상세주소</span>
							</div>
							<input type="text" class="form-control" id="addr2" name="addr2" value="${data.addr2 }" style="font-size: 17px">
						</div>		
						
						<div class="input-group mb-3 input-group-lg">
							<div class="input-group-prepend">
								<span class="input-group-text" id="span">전화번호</span>
							</div>
							<input type="text" class="form-control" id="phone" name="phone" value="${data.phone }" style="font-size: 17px">
						</div>
						
						<div class="input-group mb-3 input-group-lg">
							<div class="input-group-prepend">
								<span class="input-group-text" id="span" style="width: 96px">가입일</span>
							</div>
							<input type="text" class="form-control" id="joinDate" name="joinDate" value="${data.join_date }" readonly="readonly" style="font-size: 17px">
						</div>
						
						<div id="listView" style="margin-left: 160px; margin-top: 50px">
							<input type="button" value="수정" class="btn btn-outline-dark" id="upd" /> 
							<input type="button" value="삭제" class="btn btn-outline-dark" id="del" />
							<input type="button" value="목록보기" class="btn btn-outline-dark" id="list" onclick="location='admin_member_list.do'"/>
						</div>
					</form>
				</div>
			</div>			
			<!-- memberDivWrap -->
			
		</div>
		<!-- container -->

		<div id="footer">
			<p>
				With supporting text below as a natural lead-in to additional
				content.<br /> &copy; CopyRight. All Right Reserved. Class A
			</p>
		</div>
		<!-- footer -->
		 
	</div>
</body>
</html>
