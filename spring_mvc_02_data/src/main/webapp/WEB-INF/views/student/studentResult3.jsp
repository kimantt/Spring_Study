<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Info</title>
</head>
<body>
	command 객체 사용해서 view에 전달될 경우 : 자동으로 model에 객체(obj)로 저장해서 view 전달<br>
	표현어에 사용할 때는 객체명.필드명 형태로 사용. 단, @ModelAttribute("변경객체명") 으로 객체명 변경 후 view에 전달가능<br>
	학번 : ${studentInfo.no} <br>
	성명 : ${studentInfo.name} <br>
	학년 : ${studentInfo.year} <br>
</body>
</html>