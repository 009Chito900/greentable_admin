<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	info="판매관리"
%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매관리</title>
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
	margin:0px auto
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
	
	
	
    $.datepicker.setDefaults($.datepicker.regional['ko']); 
    $( "#orderDate" ).datepicker({
         changeMonth: true, 
         changeYear: true,
         nextText: '다음 달',
         prevText: '이전 달', 
         dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
         dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
         monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
         monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
         dateFormat: "yy-mm-dd"
         //maxDate: 0,                       // 선택할수있는 최소날짜, ( 0 : 오늘 이후 날짜 선택 불가)
       //  onClose: function( selectedDate ) {    
              //시작일(startDate) datepicker가 닫힐때
              //종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
             //$("#complete_date").datepicker( "option", "minDate", selectedDate );
         //}    

    });//datepicker

    
    $("#btn").click(function() {
    	  
    	$("#frm").submit();
  	
    });//click
 
    
    <c:if test="${move_page eq 'del'}">
		<c:if test="${delFlag}">
	alert("글이 삭제되었습니다.");
		</c:if>
		<c:if test="${not delFlag}">
	alert("글이 삭제하지 못했습니다.");
	history.back();
		</c:if>
	</c:if>
	
    
});//ready
</script>

</head>
<body>
 	<div id="wrapper">

		<div id="header">
 
			<img src="common/images/logo2.png"/>

		</div>

		<div id="container">
			 
			<ul>
			  <li><a class="active" href="#home">상품관리</a></li>
			  <li><a href="#news">판매관리</a></li>
			  <li><a href="#contact">매출조회</a></li>
			  <li><a href="#contact">문의글 관리</a></li>
			  <li><a href="#contact">회원 관리</a></li>
			</ul> 
			
<form id="frm" action="order.do" method="get">  
<div id="datePickerWrap">
	
	<input type="text" id="orderDate" name="orderDate"  value="${ param.orderDate }" style="width:120px"/>
	
	<button type="button" id="btn" class="btn btn-light">  판매상품 보기</button>
	</div>


	<c:if test="${param.orderDate != null}">
	<c:import url="/order_pocess.do"/>
	</c:if>
	
</form>
</div>
</div>		
		

		<div id="footer">
			<p>
				With supporting text below as a natural lead-in to additional
				content.<br /> &copy; CopyRight. All Right Reserved. Class A
			</p>
		</div>
		

</body>
</html>
