<%@page import="java.text.DecimalFormat"%>
<%@page import="kr.co.greentable.admin.domain.OptionDomain"%>
<%@page import="kr.co.greentable.admin.domain.OrderDomain"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	info="판매관리"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- orderdate: <c:out value="${param.orderDate }"/> --%>

<%-- <input type="hidden" id="choosedDate" name="orderDate" value="${param.orderDate }"/>  --%>

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
			
			<div id="tableWrap">
				<table class="table table-bordered">
					<c:if test="${empty list_order}">
						<tr>
							<td colspan="8">해당 일자에 판매된 상품이 존재하지 않습니다.</td>
						</tr>
					</c:if>

					<thead>
						<tr>
							<th scope="col">구매번호</th>
							<th scope="col">아이디</th>
							<th scope="col">이름</th>
							<th scope="col">상품명</th>
							<th scope="col">판매옵션</th>
							<th scope="col">가격</th>
							<th scope="col">수량</th>
							<th scope="col">총구매액(원)</th>
						</tr>
					</thead>
					<tbody>
						<%
						DecimalFormat formatter = new DecimalFormat("###,###");
						List<OrderDomain> orederList = (List<OrderDomain>) request.getAttribute("list_order");
						List<OptionDomain> optionList = (List<OptionDomain>) request.getAttribute("list_option");

						OrderDomain od = null;
						OptionDomain optD = null;

						for (int i = 0; i < orederList.size(); i++) {
							od = orederList.get(i);
						%>
						<tr>
							<td>
							<a href="order_detail.do?order_num=<%=od.getOrder_num() %>&orderDate=${param.orderDate }"><%=od.getOrder_num()%></a></td>
							<td><%=od.getId()%></td>
							<td><%=od.getName()%></td>
							<td><%=od.getProduct_name()%></td>

							<%
								optD = optionList.get(i);
							%>
							<td><%=optD.getOption_name()%></td>
							<td><%=formatter.format(optD.getOption_price())%></td>
							<td><%=optD.getQuantity()%></td>
							<td><%=formatter.format(optD.getOption_price() * optD.getQuantity())%></td>
						</tr>
						<% } %>
					</tbody>
				</table>
			</div>

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