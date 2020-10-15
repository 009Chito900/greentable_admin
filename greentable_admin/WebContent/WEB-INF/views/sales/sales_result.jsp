<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	info="매출조회결과"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매출조회 결과</title>

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

<!-- Pie chart -->
<script type="text/javascript">

$(document).ready(function () {
	
	$("#order_date").val($("#choosedDate").val());
	
});//ready

<!-- Pie chart -->
google.charts.load("current", {packages:["corechart"]});
google.charts.setOnLoadCallback(drawChart);
function drawChart() {
	 var oceanAndRiver=${ctgSum[2] };
	 var fruits=${ctgSum[0] };
	 var grains=${ctgSum[1] };
	
  var data = google.visualization.arrayToDataTable([
    ['카테고리', '매출비율'],
    ['바다와 강',     oceanAndRiver],
    ['과수원',      fruits],
    ['쌀 잡곡',  grains],

  ]);

  var options = {
    title: '카테고리 별 매출 비율',
    pieHole: 0.4,
  };

  var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
  chart.draw(data, options);
}
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

			<input type="hidden" id="choosedDate" value="${order_date}" />

			<div id="tableWrap">

				<table class="table" style="margin-bottom: 50px">
					<c:if test="${empty total_page}">
						<tr>
							<td colspan="8">해당 일자에는 판매된 상품이 존재하지 않습니다.</td>
						</tr>
					</c:if>
					
					<c:if test="${not empty total_page}">
						<!-- Pie chart -->
						<div id="donutchart" style="width: 1600px; height: 500px; margin: auto 0px"></div>
						<tr>
							<td><strong>과수원</strong></td>
							<td style="text-align: right"><fmt:formatNumber	pattern="#,###" value="${ctgSum[0] }" />원</td>
						</tr>
						<tr>
							<td><strong>쌀 잡곡</strong></td>
							<td style="text-align: right"><fmt:formatNumber	pattern="#,###" value="${ctgSum[1] }" />원</td>
						</tr>
						<tr>
							<td><strong>바다와 강</strong></td>
							<td style="text-align: right"><fmt:formatNumber	pattern="#,###" value="${ctgSum[2] }" />원</td>
						</tr>
					</c:if>
				</table>

				<br/>
				<h5>상세매출내역</h5>
				<table class="table table-bordered">
					<tr style="text-align: center;">
						<th scope="col">카테고리</th>
						<th scope="col">상품명</th>
						<th scope="col">판매옵션</th>
						<th scope="col">가격</th>
						<th scope="col">수량</th>
						<th scope="col">판매액</th>
					</tr>
					
					<c:forEach var="sl" items="${sales_list }">
						<tr>
							<td><c:out value="${sl.main_ctg_name }" /></td>
							<td><c:out value="${sl.product_name}" /></td>
							<td><c:out value="${sl.option_name}" /></td>
							<td><fmt:formatNumber pattern="#,###" value="${sl.option_price}" /></td>
							<td><fmt:formatNumber pattern="#,###" value="${sl.quantity}" />
							</td>
							<td><fmt:formatNumber pattern="#,###" value="${sl.total_price}" /></td>
						</tr>
					</c:forEach>

				</table>
			</div>

			<c:if test="${not empty total_page}">

				<nav aria-label="Page navigation example">
					<ul class="pagination" style="width: 250px; background-color: white">

						<c:forEach begin="1" end="${total_page }" step="1" var="num">
							<li class="page-item"><a class="page-link"
								href="sales.do?paramPage=${num}&order_date=${param.order_date}">${ num }</a></li>
						</c:forEach>
					</ul>
				</nav>
				
			</c:if>

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
