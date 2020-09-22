<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="에러발생시 보여줄 페이지"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

<script type="text/javascript">
   $(function(){
      
   });//ready
</script>
</head>
<body>
<div id="wrap">
   <div id="header">
      <div id="headerTop">
         <div id="mainText" title="클라쓰 A">Class A</div>
      </div>
      <div id="naviBar">
         
      </div>
   </div>
   <div id="container">
      
      <strong>문제발생</strong>
      <div>
      <c:out value="${errMsg }"/>에 대한 문제가 발생하였습니다.
      </div>
      
   </div>
   <div id="footer">
      <div id="footerLogo"> </div>
      <div id="footerContnent">
         &copy;CopyRight. All Right Reserved. Class A
      </div>
   </div>
</div>
</body>
</html>