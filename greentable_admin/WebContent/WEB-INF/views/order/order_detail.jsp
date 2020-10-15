<%@page import="java.text.DecimalFormat"%>
<%@page import="kr.co.greentable.admin.domain.OptionDomain"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.greentable.admin.domain.OrderDomain"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	info="판매관리"
%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매관리</title>

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

/* 내가 추가  */
#contents{
	margin: 0px auto;
	padding-top:30px;
}

#datePickerWrap{
	width:1300px;
	padding-top:30px;
	padding-left:30px;
	padding-bottom:30px;
}
#tableWrap{
	width:1300px;
	margin:0px, auto;
}
	
#delBtnWrap{
	text-align:right;
	margin-bottom: 30px;
}
</style>

<!-- DatePicker -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script type="text/javascript">
$(function(){

$("#delBtn").click(function(){
	
	if(confirm("글을 삭제하시겠습니까")){
	  $("#frm").submit();
	}///end if

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

			<div id="datePickerWrap"></div>
			<form id="frm" action="order_delete.do">
				<div id="delBtnWrap">
					<input type="button" id="delBtn" value="환불/구매취소" class="btn btn-success" />
					 <input type="hidden" name="chosen_order_num" value="${param.order_num}" /> 
					 <input type="hidden" name="orderDate" value="${param.orderDate}" />
				</div>
			</form>

			<div id="tableWrap">
				<table class="table table-bordered">
					<c:if test="${empty list_order}">
						<tr>
							<td colspan="5">입력된 데이터가 존재하지 않습니다.</td>
						</tr>
					</c:if>

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
						<td><%=od.getOrder_num()%></td>
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
						<%
						%>
					</tr>
					<% } %>
				</table>

				<table class="table table-bordered">
					<tr>
						<th scope="col">수신인</th>
						<th scope="col">연락처</th>
						<th scope="col">기본주소</th>
						<th scope="col">상세주소</th>
						<th scope="col">우편번호</th>
					</tr>
					<tr>
						<td><c:out value="${receiver_detail.receiver_name }" /></td>
						<td><c:out value="${receiver_detail.receiver_phone}" /></td>
						<td><c:out value="${receiver_detail.receiver_addr1}" /></td>
						<td><c:out value="${receiver_detail.receiver_addr2}" /></td>
						<td><c:out value="${receiver_detail.receiver_zipcode}" /></td>
					</tr>
				</table>
			</div>
			<!-- tableWrap -->
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
