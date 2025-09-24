<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Info</title>
</head>
<body>
	학번 : ${no} <br>
	성명 : ${name} <br>
	학년 : ${year} <br>
	
	<br>
	url을 통한 데이터 전달<br>
	학번은 서버에서 전달해서 해당 학번 학생의 정보를 확인<br>
	http://localhost:8080/project2/student/studentDetailView/001<br>
	학번 : <a href="/project2/student/studentDetailView/${no}">${no}</a>
	<br>
	url을 통한 데이터 여러개 전달<br>
	학번 : <a href="/project2/student/studentDetailView/${no}/${name}/${year}">${no}</a>
	<br>
	url을 통한 정적 데이터 여러개 전달<br>
	학번 : <a href="/project2/student/studentDetailView/1/홍길동/3">정적데이터 url로 전달</a>
</body>
</html>