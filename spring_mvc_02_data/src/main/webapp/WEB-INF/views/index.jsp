<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	index 페이지입니다<br>
	
	<a href="/project2/showInfo">showInfo</a><br>
	<a href="/project2/showInfo2">showInfoMV</a><br>
	<a href="/project2/showInfo3">showInfoMV+MODEL</a><br>
	<a href="/project2/bookInfoView1">bookInfo1</a><br>
	<a href="/project2/bookInfoView2">bookInfo2</a><br>
	<hr>
	<h3>학생정보</h3>
	<a href="/project2/student/studentForm">학생정보입력(정적 경로)</a><br>
	<a href="<c:url value='/student/studentForm2'/>">학생정보입력2(동적 경로)</a><br>
	<hr>
	<h3>상품 메뉴</h3>
	<a href="<c:url value='/product/productForm'/>">상품 등록</a><br>
</body>
</html>