<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	info="매출조회메인페이지"
%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매출조회</title>
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

/* 내가 추가  */
#contents {
	margin: 0px auto;
	padding-top:30px;
}

#datePickerWrap {
	width:1300px;
	padding-top:30px;
	padding-left:30px;
	padding-bottom:30px;
}

#tableWrap {
	width:1300px;
	margin:0px, auto;
	
}
</style>
<!-- DatePicker -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<!-- DatePicker -->

<script type="text/javascript">

$(document).ready(function () {
    $.datepicker.setDefaults($.datepicker.regional['ko']); 
    $( "#order_date" ).datepicker({
         changeMonth: true, 
         changeYear: true,
         nextText: '다음 달',
         prevText: '이전 달', 
         dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
         dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
         monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
         monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
         dateFormat: "yy-mm-dd",
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
 
   if($("#order_date").val().length>10 ){
	   
	   $("#order_date").val("");
   }//end if
    
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

			<form id="frm" action="sales.do" method="get">
				<div id="datePickerWrap">
					<input type="text" id="order_date" name="order_date"
						placeholder="날짜 선택" style="width: 120px" />
					<button type="button" id="btn" class="btn btn-light">매출 보기</button>
				</div>
				
				<div id="tableWrap">
					<c:if test="${param.order_date != null}">
						<c:import url="/sales_process.do" />
					</c:if>
				</div>
			</form>
			
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
