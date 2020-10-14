<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	info="관리자 템플릿"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 템플릿</title>

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
$(function(){
    $("#productBtn").click(function(){
    	location.href ="product_mng_frm.do";
    });
    
    $("#mainCtg").change(function() { //수정 필요 전에 있던 목록이 남음 현재 목록에 아무것도 없을시
		$.ajax({
			url: "select_list.do",
			data:"mainCtg="+$("#mainCtg").val(),
			type:"GET",	
			dataType:"text",
			/* error:function(xhr){
				alert("에러");
				console.log(xhr.status+"/"+xhr.status.Text);
			}, */ error: function(jqXHR, textStatus, errorThrown) {

		    	console.log("error "+(new Date()));

		        var errorMsg = 'status(code): ' + jqXHR.status + '\n';

		        errorMsg += 'statusText: ' + jqXHR.statusText + '\n';

		        errorMsg += 'responseText: ' + jqXHR.responseText + '\n';

		        errorMsg += 'textStatus: ' + textStatus + '\n';

		        errorMsg += 'errorThrown: ' + errorThrown;

		        console.log(errorMsg);



		    },
			success:function(jsonText){
					alert(jsonText);
					var jo = JSON.parse(jsonText);
				try{
				if(jo.productCnt != 0){
					alert(jo.productCnt);
					$.each(jo.productList,function(i, json){
						
						var productTR = 
									 "<tr>"
									  +"<td><c:out value='"+json.productMainCtg+"'/></td>"
									  +"<td><c:out value='"+json.productSubCtg+"'/></td>"
									  +"<td><a href='product_mng_detail.do?productNum="+json.productNum+"'><c:out value='"+json.productName+"'/></a></td>"
									  +"<td><c:out value='"+json.productOptionName+"'/></td>"
									  +"<td><c:out value='"+json.productOptionPrice+"'/></td>"
									  +"<td><c:out value='"+json.productOnSale+"'/></td>"
									  +"<td><c:out value='"+json.productTextInfo+"'/></td>"
									  +"</tr>";
						$("#goodBody").append(productTR);
					});//each
				}//end if
				}catch (e) {
					alert("Output is not valid JSON: "+json_output);
				}
			}//end success
		});//ajax
	});
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
		<div>
			<select id="mainCtg" name="mainCtg" style="margin-top: 20px;">
				<option>대카테고리 선택</option>
				<c:forEach var="mc" items="${mainCtgList }">
				<option><c:out value="${mc.main_ctg_name }"/></option>
				</c:forEach>
			</select>
			<input type="button" class="btn btn-success" id="productBtn"value="상품등록" style="margin-top: 5px;margin-left: 30px;" />
		</div>
		<!-- container -->
		<table class="table" style="text-align: center;margin-top: 20px;">
  <thead class="thead-dark">
    <tr>
      <th scope="col" width="10%">대카테고리</th>
      <th scope="col" width="10%">중카테고리</th>
      <th scope="col" width="20%">상품명</th><!-- a태그 걸어 수정 폼으로 이동 -->
      <th scope="col" width="30%">판매옵션</th>
      <th scope="col" width="5%">가격</th>
      <th scope="col" width="5%">판매</th>
      <th scope="col" width="20%">정보</th>
    </tr>
  </thead>
  <tbody id="goodBody">
  <c:if test="${mainCtg eq null }">
  <c:forEach var="pd" items="${pdList }">
  <tr>
  <td><c:out value="${pd.main_ctg_name }"/></td>
  <td><c:out value="${pd.sub_ctg_name}"/></td>
  <td><a href="product_mng_detail.do?productNum=${pd.product_num }"><c:out value="${pd.product_name }"/></a></td>
  <%-- <td>
  <select name="optionName">
  <c:forEach var="pod" items="${pd.podList }">
  <option><c:out value="${pod.option_name }"/></option>
  </c:forEach>
  </select>
  </td> --%>
  <td><c:out value="${pd.podList[0].option_name }"/></td>
  <td><c:out value="${pd.podList[0].option_price }"/></td>
  <td><c:out value="${pd.on_sale }"/></td>
  <td><c:out value="${pd.pro_text_info }"/></td>
  </tr>
  </c:forEach>
  </c:if>
  </tbody>
</table>
		</div>
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
