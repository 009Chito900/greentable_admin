<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	info="관리자 회원관리 페이지" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" type="text/css"href="http://211.238.142.27/group3_admin/common/css/main.css"> -->
<title>관리자 회원관리</title>
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
	min-height: 450px; 
	margin: 0px auto;
	margin-top: 120px;
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

.results tr[visible='false'],
.no-result{
  display:none;
}

.results tr[visible='true']{
  display:table-row;
}

.counter{
  padding:8px; 
  color:#ccc;
}

#form-group {
	width: 300px;
}

.pagination {
	width: 200px;
	margin: 0 auto;
	margin-top: 50px;
}
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

<script type="text/javascript">
$(document).ready(function() {
	  $(".search").keyup(function () {
	    var searchTerm = $(".search").val();
	    var listItem = $('.results tbody').children('tr');
	    var searchSplit = searchTerm.replace(/ /g, "'):containsi('")
	    
	  $.extend($.expr[':'], {'containsi': function(elem, i, match, array){
	        return (elem.textContent || elem.innerText || '').toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
	    }
	  });
	    
	  $(".results tbody tr").not(":containsi('" + searchSplit + "')").each(function(e){
	    $(this).attr('visible','false');
	  });

	  $(".results tbody tr:containsi('" + searchSplit + "')").each(function(e){
	    $(this).attr('visible','true');
	  });

	  var jobCount = $('.results tbody tr[visible="true"]').length;
	    $('.counter').text(jobCount + ' item');

	  if(jobCount == '0') {$('.no-result').show();}
	    else {$('.no-result').hide();}
			  });
	}); 

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

			<a href="admin_member_list.do">모든 리스트 조회</a>

			<div id="form-group">
				<input type="text" class="search form-control" placeholder="아이디 검색">
			</div>
			
			<span class="counter"></span>
			<table class="table table-hover table-bordered results">
				<thead>
					<tr>
						<th style="width: ">#</th>
						<th>아이디</th>
						<th>이름</th>
						<th>이메일</th>
						<th>가입일</th>
					</tr>
				<%-- 	<c:if test="${empty list_date }" />
					<tr>
						<td colspan="2">입력된 데이터가 존재하지 않습니다.</td>
					</tr> --%>
					<tr class="warning no-result">
						<td colspan="4"><i class="fa fa-warning"></i> No result</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="md" items="${member_list }">
					<tr>
						<td><a href="admin_memberInfo.jsp"><c:out value="${md.id }"/></a></td>
						<td><c:out value="${md.name}"/></td>
						<td><c:out value="${md.email}"/></td>
						<td><c:out value="${md.join_date}"/></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>

			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
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
