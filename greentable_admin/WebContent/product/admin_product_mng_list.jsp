<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	info="관리자 템플릿"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 템플릿</title>

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
</style>
<script type="text/javascript">
$(function(){
    $("#productBtn").click(function(){
    	location.href ="admin_product_mng_frm.jsp";
    });
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
		<div>
			<select name="mctg" style="margin-top: 20px;">
				<option>대카테고리 선택</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
			</select>
			<input type="button" class="btn btn-success" id="productBtn"value="상품등록" style="margin-top: 5px;margin-left: 30px;" />
		</div>
		<!-- container -->
		<table class="table" style="text-align: center;margin-top: 20px;">
  <thead class="thead-dark">
    <tr>
      <th scope="col" width="10%">대카테고리</th>
      <th scope="col" width="10%">중카테고리</th>
      <th scope="col" width="20%">상품명</th><!-- a태그 걸어 수정 폼으로 이동 -->
      <th scope="col" width="20%">판매옵션</th><!-- select로 표현 -->
      <th scope="col" width="5%">가격</th>
      <th scope="col" width="20%">담당자</th>
      <th scope="col" width="15%">정보</th>
    </tr>
  </thead>
  <!-- foreach 때리면됨 -->
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>@twitter</td>
    </tr>
  </tbody>
</table>
		</div>
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
