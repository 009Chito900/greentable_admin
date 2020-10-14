<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="관리자 템플릿"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 템플릿</title>

<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<!-- 다음 우편 번호 API -->
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- Google CDN -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<!-- 부트스트랩 -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="http://localhost/greentable_admin/common/css/admin-header.css">

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
.form-group row{
	margin-top: 30px;
}
</style>
<script type="text/javascript">
	$(function() {
		var i=1;
		$("#addBtn").click(function(){
			$("#addOptionPrice").append("<div class='form-group row'>"
					+"<label for='productOption' class='col-sm-2 col-form-label'"
					+"style='font: bold 10px;'>옵션명</label>"
					+"<div class='col-sm-4'>"
					+"<input type='text' class='form-control' name='productOption'"
					+"id='productOption'></div>"
					+"<label for='productPrice' class='col-sm-2 col-form-label'>가격</label>"
					+"<div class='col-sm-4'>"
					+"<input type='text' class='form-control' name='productPrice'"
					+"id='productPrice'>"
					+"</div></div>");
			
			i++;
			$("#optionCnt").val(i);
		});
		
		$("#delBtn").click(function(){
			$("#addOptionPrice > div:last").remove();
			i--;
			$("#optionCnt").val(i);
		});
		
		$("#modiProductBtn").click(function(){
			alert($("#frm").serialize());
			$("#mdFlag").val("modi");
			$("#frm").submit();
		});

		$("#delProductBtn").click(function(){
			alert($("#frm").serialize());
			$("#mdFlag").val("del");
			$("#frm").submit();
		});
		
		$("#mainCtg").change(function() { //수정 필요 전에 있던 목록이 남음 현재 목록에 아무것도 없을시
			$.ajax({
				url: "select_subCtg.do",
				data:"mainCtg="+$("#mainCtg").val(),
				type:"GET",	
				dataType:"JSON",
				error:function(xhr){
					alert("에러");
					console.log(xhr.status+"/"+xhr.status.Text);
				},
				success:function(jsonObj){
					if(jsonObj.dataCnt != 0){
						var subCtg=document.getElementById("subCtg");
						subCtg.length=1; //남겨둘 옵션의 개수
						
						$.each(jsonObj.subCtgList,function(i, json){
							subCtg.options[i+1]=new Option(json.subCtg);
						});//each
					}//end if
				}//end success
			});//ajax
		});
		
		$("#proImgInfo").change(function(e) {
			$("[for=proImgInfo]").text(e.target.files[0].name);
			$("#proImgInfoName").val(e.target.files[0].name);
		});
		$("#proImgThumb").change(function(e) {
			$("[for=proImgThumb]").text(e.target.files[0].name);
			$("#proImgThumbName").val(e.target.files[0].name);
		});
		
	});//ready
	
	function nullChk(){
		if($("#productName").val()== null){
			$("#productName").val("");
		}
		if($("#proImgInfoName").val()== null){
			$("#proImgInfoName").val("");
		}
		if($("#proImgThumbName").val()== null){
			$("#proImgThumbName").val("");
		}
		if($("#productTooltip").val()== null){
			$("#productTooltip").val("");
		}
		if($("#mainCtg").val()== null){
			$("#mainCtg").val("");
		}
		if($("#subCtg").val()== null){
			$("#subCtg").val("");
		}
		if($("#onSale").val()== null){
			$("#onSale").val("N");
		}
		if($("#proTextInfo").val()== null){
			$("#proTextInfo").val("");
		}
		if($("#productName").val()== null){
			$("#productName").val("");
		}
		if($("#productName").val()== null){
			$("#productName").val("");
		}
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
		<form action="product_mnr.do" method="post" enctype="multipart/form-data" id="frm">
				<div class="form-group row">
					<label for="productName" class="col-sm-2 col-form-label">상품명</label>
					<div class="col-sm-4">
						<input type="hidden" name="productNum" id="productNum" value="${fn:trim(pdd.product_num) }"/>
						<input type="text" class="form-control" name="productName"
							id="productName" value="${pdd.product_name }"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="proTextInfo" class="col-sm-2 col-form-label">상품설명</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="proTextInfo"
							id="proTextInfo" value="${pdd.pro_text_info }"/>
					</div>
				</div>
			<div class="form-group row">
				<label for="mainCtg" class="col-sm-2 col-form-label"
					style="font: bold 10px;">카테고리:대분류</label>
				<div class="col-sm-2">
					<select id="mainCtg" name="mainCtg" class="form-control"
						style="text-align: center;">
						<option>선택</option>
						<c:forEach var="mc" items="${mainCtgList }">
				<option ${mc.main_ctg_name eq pdd.main_ctg_name?"selected='selected'":"" }><c:out value="${mc.main_ctg_name }"/></option>
				</c:forEach>
					</select>
				</div>
				<label for="subCtg" class="col-sm-2 col-form-label"
					style="margin-left: 220px;">카테고리:중분류</label>
				<div class="col-sm-2">
					<select id="mainCtg" name="subCtg" class="form-control"
						style="text-align: center;">
						<option>선택</option>
						<c:forEach var="sc" items="${subCtgList }">
				<option ${sc.sub_ctg_name eq pdd.sub_ctg_name?"selected='selected'":"" }><c:out value="${sc.sub_ctg_name }"/></option>
				</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="productTooltip" class="col-sm-2 col-form-label"
					style="font: bold 10px;">툴팁</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="productTooltip" id="productTooltip" value="${pdd.product_tooltip }"/>
				</div>
				<label for="onSale" class="col-sm-2 col-form-label">판매여부</label>
				<div class="col-sm-2">
					<select id="onSale" name="onSale" class="form-control">
						<option>선택</option>
						<c:forEach var="onSale" items="${onSaleArr }">
						<option value="${onSale }" ${onSale eq pdd.on_sale?"selected='selected'":"" }><c:out value="${onSale }"/></option>
						</c:forEach>
					</select>
				</div>
			</div>
			<c:forEach var="pod" items="${pdd.podList }">
			<div class="form-group row">
				<label for="productOption" class="col-sm-2 col-form-label"
					style="font: bold 10px;">옵션명</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="productOption"
						id="productOption" value="${pod.option_name }"/>
				</div>
				<label for="productPrice" class="col-sm-2 col-form-label">가격</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="productPrice"
						id="productPrice" value="${pod.option_price }"/>
				</div>
			</div>
			</c:forEach>
			
			<div id="addOptionPrice">
				<input type="hidden" name="optionCnt" id="optionCnt" value="0"/>
			</div>
			<div class="form-group row" style="margin-left: 600px; margin-top:30px;margin-bottom:30px;">
				<button type="button" class="btn btn-info" id="addBtn"
				style="font-size: 13px;font-weight: bold;width:60px;height:30px;text-align: center;">추가</button>
				<button type="button" class="btn btn-danger" id="delBtn"
				style="font-size: 13px;font-weight: bold;width:60px;height:30px;margin-left:20px;text-align: center;">제거</button>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2 col-form-label"
					style="font: bold 10px;">상세정보(이미지)</label>
				<div class="custom-file col-sm-4" style="margin-left: 15px;">
					<input type="file" class="custom-file-input" id="proImgInfo">
					<input type="hidden" name="proImgInfoName" id="proImgInfoName" value="${pdd.pro_img_info }">
					<label class="custom-file-label" for="proImgInfo"><c:out value="${pdd.pro_img_info }"/></label>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label"
					style="font: bold 10px;">썸네일사진</label>
				<div class="custom-file col-sm-4" style="margin-left: 15px;">
					<input type="file" class="custom-file-input" id="proImgThumb">
					<input type="hidden" name="proImgThumbName" id="proImgThumbName" value="${pdd.pro_img_thumb }">
					<label class="custom-file-label" for="proImgThumb"><c:out value="${pdd.pro_img_thumb }"/></label>
				</div>
			</div>
			<div style="float:right;">
			<input type="hidden" id="mdFlag" name="mdFlag" value=""/>
			<input type="button" class="btn btn-primary" id="modiProductBtn" value="수정" style=""/>
			<input type="button" class="btn btn-danger" id="delProductBtn" value="삭제" style="marign-left:20px;"/>
			</div>
		</form>
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
