<%@page import="java.text.DecimalFormat"%>
<%@page import="kr.co.greentable.admin.domain.OptionDomain"%>
<%@page import="kr.co.greentable.admin.domain.OrderDomain"%>
<%@page import="java.util.List"%>
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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Inconsolata">
<style>
 
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
/* 내가 추가  */

</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<!-- DatePicker -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<!-- DatePicker -->

<script type="text/javascript">

$(document).ready(function () {
//	$("#orderDate").val($("#choosedDate").val());

	/*  
    <c:if test="${move_page eq 'del'}">
		<c:if test="${delFlag}">
	alert("글이 삭제되었습니다.");
		</c:if>
		<c:if test="${not delFlag}">
	alert("글이 삭제하지 못했습니다.");
	history.back();
		</c:if>
	</c:if> */
	   if($("#orderDate").val().length>10 ){
		   
		   $("#orderDate").val("");
	   }
	    
	
	
});//ready
</script>

</head>
<body>
<%-- orderdate: <c:out value="${param.orderDate }"/> --%>

<input type="hidden" id="choosedDate" name="orderDate" value="${param.orderDate }"/> 
 	
	<div id="tableWrap">
		<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">구매번호</th>
      <th scope="col">아이디</th>
      <th scope="col">이름</th>
      <th scope="col">상품명</th>
      <th scope="col">판매옵션</th>
      <th scope="col">가격</th>
      <th scope="col">수량</th>
      <th scope="col">총구매액</th>
    </tr>
  </thead>
  <tbody>
  <c:if test="${empty list_order}">
  <tr>
  <td colspan="8">해당 일자에 판매된 상품이 존재하지 않습니다.</td>
  </tr>
  </c:if>
  
    
    <% 
    DecimalFormat formatter=new DecimalFormat("###,###");
    List<OrderDomain> orederList=( List<OrderDomain>)request.getAttribute("list_order");
    List<OptionDomain> optionList=( List<OptionDomain>)request.getAttribute("list_option");
    
    OrderDomain od=null;
    OptionDomain optD=null;
    
   	for( int i=0 ;i <orederList.size();i++){
   		
   		od=orederList.get(i);
   
   		%>
   		
   		<tr>
		<td><a href="order_detail.do?order_num=<%=od.getOrder_num() %>&orderDate=${param.orderDate }"><%=od.getOrder_num() %></a></td>
   		<td><%= od.getId() %></td>
   		<td><%= od.getName() %></td>
   		<td><%= od.getProduct_name() %></td>

   		<%
   			optD=optionList.get(i);
   			 %>
   			 <td><%= optD.getOption_name() %></td>
   			 <td><%= formatter.format(optD.getOption_price())%></td>
   			 <td><%= optD.getQuantity() %></td>
   			 <td><%= formatter.format(optD.getOption_price()*optD.getQuantity())%></td>
   			 
   			
   		</tr>
   		<%
    	
    }
    %>

 
    </tbody>
    
    </table>
		</div>


</body>
</html>
