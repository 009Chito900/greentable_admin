<%@page import="java.text.DecimalFormat"%>
<%@page import="kr.co.greentable.admin.domain.OptionDomain"%>
<%@page import="kr.co.greentable.admin.domain.OrderDomain"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	info="판매관리"
%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 	
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
      </table>
	</div>
    
<c:if test="${not empty list_order}">	
	<div id="pageNation" style="margin-bottom: 50px; ">	

<nav aria-label="Page navigation example">
  <ul class="pagination" style="width:250px; background-color: white">
    <li class="page-item">
      <a class="page-link" href="order.do?paramPage=1&order_date=${param.order_date}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    	<c:forEach begin="1" end="${total_page }" step="1" var="num">
   		 <li class="page-item" ><a class="page-link" href="order.do?paramPage=${num}&order_date=${param.order_date}">${ num }</a></li>
		</c:forEach>
		<li class="page-item">
      <a class="page-link" href="order.do?paramPage=${total_page}&order_date=${param.order_date}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
			</div>
</c:if>
    </tbody>

  