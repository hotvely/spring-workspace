<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateMember" method="post">
		변경할 비밀번호 :	<input type="text" name="pwd"> 
		변경할 이름 : <input type="text"	name="name">
		변경할 주소 : <input type="text"	name="addr">
		<input type="submit" value="전송!">
	</form>
</body>
</html>