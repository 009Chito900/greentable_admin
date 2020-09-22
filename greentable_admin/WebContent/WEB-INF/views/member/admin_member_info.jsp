<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	info="관리자 페이지"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 회원관리 수정</title>
<style>
#wrap {
	width: 1300px;
	height: 930px;
	margin: 0px auto;
}

#header {
}

#container {
	position: relative;
	width: 1300px;
	min-height: 600px; 
	margin: 0px auto;
	margin-top: 80px;
}

#footer {
	width: 100%;
	padding: 20px;
	position: relative;
	text-align: center;
	height: 100px;
	background-color: /* #F6F6F6 */;
	margin-top: 100px;
}

img {
	width: 200px;
	margin-left: 45%;
	margin-top: 20px;
	margin-bottom: 30px;
}

ul {
	list-style-type: none;
  	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #264429;
	position: -webkit-sticky; /* Safari */
	position: sticky;
	top: 0;
}

li {
	float: left;
	width: 20%;
	line-height: 55px;
	text-align: center;
}

li a {
	display: block;
	color: white;
	text-decoration: none;
	font-size: 18px;
}

li a:hover {
	color: #fff;
	text-decoration: none;
	background-color: #264429;
}

/* 선택된 메뉴 표시 */
.active {
	background-color: #264429;
}

</style>
<!-- 다음 우편 번호 API -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> 
<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">

$(function(){
	
	//우편번호 검색
	$("[value='검색']").click(function() {
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
		
});//ready

</script>

</head>
<body>
	<div id="wrapper">

		<div id="header">
 
			<img src="http://localhost/final_prj/common/images/logo3.png"/>
			
			<ul>
			  <li><a class="active" href="#home">상품관리</a></li>
			  <li><a href="#news">판매관리</a></li>
			  <li><a href="#contact">매출조회</a></li>
			  <li><a href="#contact">문의글 관리</a></li>
			  <li><a href="#contact">회원 관리</a></li>
			</ul>

		</div>
 
		<div id="container">
			
			<div id="memberDiv">
				<form action="" name="frm">
					<table>
						<tr>
							<th><span class="point"></span>아이디</th>				
							<td><input type="text" style="width: 120px" class="inputBox" name="id" id="id" readonly="readonly"/>&nbsp;
						</tr>
						<tr>
							<th><span class="point"></span>이메일</th>
							<td>
								<input type="email" style="width: 120px" name="email1" id="email" class="inputBox"/>
							</td>
						</tr>
						<tr>
							<th><span class="point"></span>우편번호</th>
							<td>
								<input type="text" style="width: 80px" name="zipcode" id="zipcode" class="inputBox" readonly="readonly"/>
								<input type="button" value="검색" class="btn" />
							</td>
						</tr>
						<tr>
							<th><span class="point"></span>주소</th><td>
							<input type="text" style="width: 300px" name="addr1" id="addr1" class="inputBox" readonly="readonly"></td>
						</tr>
						<tr>
							<th><span class="point"></span>상세주소</th>
							<td><input type="text" style="width: 300px" name="addr2" id="addr2" class="inputBox"></td>
						</tr>
						<tr>
							<th><span class="point"></span>전화번호</th>
							<td><input type="text" style="width: 120px" name="phone" id="phone" class="inputBox"></td>
						</tr>
						<tr>
							<th><span class="point"></span>가입일</th>
							<td><input type="text" style="width: 120px" name="input_date" id="input_date" class="inputBox"></td>
						</tr>
						<tr>
							<th colspan="2" style="text-align: center">
								<input type="button" value="수정" class="btn" />
								<input type="reset" value="삭제" class="btn" />
							</th>
						</tr>
					</table>
				</form>
			</div>
			
		</div>

		<div id="footer">
			<p>
				With supporting text below as a natural lead-in to additional
				content.<br /> &copy; CopyRight. All Right Reserved. Class A
			</p>
		</div>
		 
	</div>

</body>
</html>
