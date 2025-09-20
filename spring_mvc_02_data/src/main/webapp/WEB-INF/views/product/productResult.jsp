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
	상품번호 : ${no}<br>
	상품명 : ${name}<br>
	가격 : ${price}원<br>
	제조회사 : ${company}<br>
	제조일 : ${date}<br>
	재고 : ${stock}개<br>
	<button onClick="location.href='<c:url value='/'/>'">메인으로</button>
</body>
</html>