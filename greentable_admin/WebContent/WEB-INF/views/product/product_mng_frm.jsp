<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="관리자 템플릿"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		
		$("#imgBtn").click(function(){
			var height = '300';
			var width = '500';
			var left = Math.ceil((window.screen.width-width)/2); 
			var top = Math.ceil((window.screen.height-height)/2); 
			window.open("product_img_frm.do","up",
					"width="+width+",height="+height+",left="+left+",top="+top);
		});

		$("#prgBtn").click(function(){
//			console.log($("#frm").serialize());
			alert($("#frm").serialize());
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
					alert(jsonObj);
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
		<form action="product_process.do" method="post" enctype="multipart/form-data" id="frm">
				<div class="form-group row">
					<label for="productName" class="col-sm-2 col-form-label">상품명</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="productName"
							id="productName">
					</div>
				</div>
				<div class="form-group row">
					<label for="proTextInfo" class="col-sm-2 col-form-label">상품설명</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="proTextInfo"
							id="proTextInfo">
					</div>
				</div>
			<div class="form-group row">
				<label for="mainCtg" class="col-sm-2 col-form-label"
					style="font: bold 10px;">카테고리:대분류</label>
				<div class="col-sm-2">
					<select id="mainCtg" name="mainCtg" class="form-control"
						style="text-align: center;">
						<option selected="selected">선택</option>
						<option>과수원</option>
						<option>쌀 잡곡</option>
						<option>바다와 강</option>
					</select>
				</div>
				<label for="subCtg" class="col-sm-2 col-form-label"
					style="margin-left: 220px;">카테고리:중분류</label>
				<div class="col-sm-2">
					<select name="subCtg" id="subCtg" class="form-control">
						<option selected="selected">선택</option>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="productTooltip" class="col-sm-2 col-form-label"
					style="font: bold 10px;">툴팁</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="productTooltip" id="productTooltip">
				</div>
				<label for="onSale" class="col-sm-2 col-form-label">판매여부</label>
				<div class="col-sm-2">
					<select id="onSale" name="onSale" class="form-control">
						<option selected="selected">선택</option>
						<option>Y</option>
						<option>N</option>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="productOption" class="col-sm-2 col-form-label"
					style="font: bold 10px;">옵션명</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="productOption"
						id="productOption">
				</div>
				<label for="productPrice" class="col-sm-2 col-form-label">가격</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="productPrice"
						id="productPrice">
				</div>
			</div>
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
					<input type="file" class="custom-file-input" name="proImgInfo" id="proImgInfo"/>
					<input type="hidden" name="proImgInfoName" id="proImgInfoName" value=""/>
					<label class="custom-file-label" for="proImgInfo">이미지 선택</label>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label"
					style="font: bold 10px;">썸네일사진</label>
				<div class="custom-file col-sm-4" style="margin-left: 15px;">
					<input type="file" class="custom-file-input" name="proImgThumb" id="proImgThumb"/>
					<input type="hidden" name="proImgThumbName" id="proImgThumbName" value=""/>
					<label class="custom-file-label" for="proImgThumb">이미지 선택</label>
				</div>
			</div> 
			
			<input type="button" class="btn btn-primary" id="prgBtn" value="상품등록" style="float:right;"/>
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
