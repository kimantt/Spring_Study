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
	<a href="<c:url value='/student/studentForm3'/>">학생정보입력3(command 객체)</a><br>
	<a href="<c:url value='/student/studentForm4'/>">학생정보입력4(command 객체 + @ModelAttribute)</a><br>
	<a href="<c:url value='/student/studentForm5'/>">학생정보입력5(Date 타입의 정보 전달)</a><br>
	<a href="<c:url value='/student/studentSearchForm'/>">학생정보검색(여러 정보 HashMap에 저장)</a><br>
	<hr>
	<h3>상품 메뉴</h3>
	<a href="<c:url value='/product/productForm'/>">상품 등록</a><br>
	<a href="<c:url value='/product/productForm3'/>">상품 등록(command 객체)</a><br>
	<a href="<c:url value='/product/productForm4'/>">상품 등록(@ModelAttribute 사용)</a><br>
	<a href="<c:url value='/product/productSearchForm'/>">상품 검색</a><br>
	
	<hr>
	<h3>redirect</h3>
	<a href="<c:url value='/redirect'/>">redirect</a><br>
	<a href="<c:url value='/redirectParam1'/>">redirect-쿼리스트링</a><br>
	<a href="<c:url value='/redirectParam2'/>">redirect-모델 객체에 추가</a><br>
	<a href="<c:url value='/redirectParam3'/>">redirect-리다이렉트 속성 객체에 추가</a><br>
</body>
</html>