<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Result</title>
</head>
<body>
	<h3>상품 등록 정보</h3>
	상품번호 : ${product.no}<br>
	상품명 : ${product.name}<br>
	가격 : ${product.price}원<br>
	제조회사 : ${product.company}<br>
	제조일 : ${product.date}<br>
	재고 : ${product.stock}개<br>
	<button onClick="location.href='<c:url value='/'/>'">메인으로</button>
</body>
</html>