<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	info="관리자:문의글상세보기(답변완료)"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의글상세보기(답변완료)</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Inconsolata">
<style>
#wrap {
	width: 1300px;
	height: 930px;
	margin: 0px auto;
}

#header {
	width: 1300px;
	height: 20px;
}

#container {
	position: relative;
	width: 1300px;
	min-height: 600px;
	position: relative;
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
	margin-left: 550px
}

ul {
	list-style-type: none;
	margin: 0 auto;
	padding: 0;
	overflow: hidden;
	background-color: #264429;
	position: -webkit-sticky; /* Safari */
	position: sticky;
	top: 0;
	overflow: hidden;
}

li {
	float: left;
	width: 20%;
	height: 45px;
	line-height: 50px;
	text-align: center;
}

li a {
	display: block;
	color: white;
	text-decoration: none;
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

/**************************** 타이틀:문의글  **************************************/
#askTitle{
	margin-top: 3%;
	margin-left: 2%
}
/**************************** 타이틀:문의글  **************************************/
/**************************** 테이블  **************************************/
/* 테이블 디자인  */
.table-responsive{
	align-content: center;
	width: 100px; 
	min-height: 300px; 
	margin-top: 50px;
	margin-right: 100px;
}

.myTable {
	border-collapse: collapse;
	width: 85%;
	border: 1px solid #ddd;
	font-size: 15px;
	text-align: center;
	color:  #fff;
	margin: 0px auto
}

.myTable th, .myTable td {
	text-align: center;
	padding: 12px;
}

.myTable tr {
	border-bottom: 1px solid #ddd;
}

.myTable tr.header{
	background-color: #264429; 
}

.myTable td {
	color: black;	
}

tbody tr:hover,.header-sub:hover {
	background-color: #F6F6F6;
}

#askContent, #askAnswer{
	text-align: left;
	width: 95%;
}

/**************************** 테이블  **************************************/
/**************************** 버튼  **************************************/
#buttonDiv{
	margin-top:2%;
	margin-right:7%;
	text-align: right;
}

#askModiBtn{
	width: 10%
}

#askRemoveBtn{
	margin-left:2%;
	width: 10%
}
/**************************** 버튼  **************************************/
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
 
			<img src="http://localhost/team_prj_5/common/images/logo2.png"/>

		</div>

		<div id="container">
			 
			<ul>
			  <li><a class="active" href="#home">상품관리</a></li>
			  <li><a href="#news">판매관리</a></li>
			  <li><a href="#contact">매출조회</a></li>
			  <li><a href="#contact">문의글 관리</a></li>
			  <li><a href="#contact">회원 관리</a></li>
			</ul>
			
			<div id="askTitle">
			<h3>문의글</h3>
			</div>

			<div class="table-responsive">
					<table class="myTable">
						<tr class="header">
							<th style="width: 20%">제목</th>
							<th style="width: 80%">어제 물건 반품했는데.. 아직 전화연락이 없어요.</th>
						</tr>
						<tbody>
						<tr class="header-sub">
							<td>내용</td>
							<td>
								<textarea id="askContent" readonly rows="8">물건 반품했는데 아직 전화연락이 없네요 연락 부탁드립니다</textarea>
							</td>
						</tr>
						<tr class="header-sub">
							<td>답변</td>
							<td>
								<textarea id="askAnswer" rows="8">답변 완료</textarea>
							</td>
						</tr>
						</tbody>
					</table>
			</div>
			<div id="buttonDiv">
				<button type="button" id="askModiBtn" class="btn btn-success">답변 수정</button>
				<button type="button" id="askRemoveBtn" class="btn btn-secondary">문의글 삭제</button>
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
