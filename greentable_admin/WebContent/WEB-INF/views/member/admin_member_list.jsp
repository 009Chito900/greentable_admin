<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	info="관리자 회원관리 페이지"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 회원관리</title>

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

.counter{
  padding:8px; 
  color:#ccc;
}

#form-group {
	width: 300px;
}

#paginationUl {
	background-color: #fff;
}

#paginationUl a {
	background-color: #fff; 
	color: #333;
	width: 30px;
}

#paginationUl a:hover {
	color: #2121FF;
}

.pagination {
	width: 200px;
	margin: 0 auto;
	margin-top: 50px;
}
</style>
<script type="text/javascript">
$(function(){
	
	<c:if test ="${ move_page eq 'del' }">
		<c:if test = "${ delFlag}">
			alert("회원이 삭제되었습니다.");
		</c:if>
		
		<c:if test = "${ not delFlag}">
			alert("회원을 삭제하지 못했습니다.");
			history.back();
	   	</c:if>
	   	
	</c:if>
	
	<c:if test ="${ move_page eq 'upd' }">
		<c:if test = "${ updFlag}">
			alert("회원이 수정되었습니다.");
		</c:if>
		
		<c:if test = "${ not updFlag}">
			alert("회원을 수정하지 못했습니다.");
			history.back();
	   	</c:if>
	   	
	</c:if>
	
	
	//회원테이블 검색
	$(".search").keyup(function () {
		var searchTerm = $(".search").val();
		var listItem = $('.results tbody').children('tr');
		var searchSplit = searchTerm.replace(/ /g, "'):containsi('")
	  
		$.extend($.expr[':'], {'containsi': function(elem, i, match, array){
		      return (elem.textContent || elem.innerText || '').toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
		}
		});//extend
		  
		$(".results tbody tr").not(":containsi('" + searchSplit + "')").each(function(e){
		  $(this).attr('visible','false');
		});//each
		
		$(".results tbody tr:containsi('" + searchSplit + "')").each(function(e){
		  $(this).attr('visible','true');
		});
		
		var jobCount = $('.results tbody tr[visible="true"]').length;
		  $('.counter').text(jobCount + ' item');
		
		if(jobCount == '0') {$('.no-result').show();}
		  else {$('.no-result').hide();}
	});//keyup
	
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

			<div id="form-group">
				<input type="text" class="search form-control" placeholder="아이디 검색">
			</div>
			
			<span class="counter"></span>
			<table class="table table-bordered results">
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>이메일</th>
						<th>가입일</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${ empty list_data }" >
					<tr>
						<td colspan="4">입력된 데이터가 존재하지 않습니다.</td>
					</tr>
					</c:if>
					<c:forEach var="smld" items="${ list_data }"> <!-- SelectMemberListDomain -->
						<tr>
							<td><a href="admin_member_detail.do?id=${ smld.id }"><c:out value="${smld.id }" /> </a></td>
							
							<td> <c:out value="${smld.name }" /></td>
							<td><c:out value="${smld.email }" /></td>
							<td><c:out value="${smld.join_date }" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<!-- Pagination -->
			<nav aria-label="Page navigation example">
			  <ul class="pagination justify-content-center" id="paginationUl">
			    <li class="page-item">
			      <a class="page-link" href="#" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			  	<c:forEach var="num" begin="1" end="${total_page }" step="1">
			   		<a href="/greentable_admin/admin_member_list.do?paramPage=${num }">${ num }</a>
			   	</c:forEach>
			    <li class="page-item">
			      <a class="page-link" href="#" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
			
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
