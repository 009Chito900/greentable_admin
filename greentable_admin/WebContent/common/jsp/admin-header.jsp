<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="관리자 헤더 메뉴"%>
<div class="headerTop">
    <a href="../login_frm.do">로그아웃</a>
</div>

<div id="logo">
	<a href="admin_main.jsp"><img src="http://localhost/greentable_admin/common/images/logo3.png"/></a>
</div>

<ul id="mainMenu">
	<li>
		<a class="active" href="product_mng_frm.do">상품관리</a>
	</li>
	<li>
		<a href="order.do">판매관리</a>
	</li>
	<li>
		<a href="sales.do">매출조회</a>
	</li>
	<li>
		<a href="ask/askList.do">문의글 관리</a>
	</li>
	<li> 
		<a href="admin_member_list.do">회원 관리</a>
	</li>
</ul>
