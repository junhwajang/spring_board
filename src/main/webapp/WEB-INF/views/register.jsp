<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Insert 예제</title>
</head>
<body>

	<form action="/register" method="post">
		
		타이틀 입력 : <input type="text" name="btitle"><br>
		내용 입력 : <input type="text" name="bcontent"><br>
		작성자 입력 : <input type="text" name="bwriter"><br>
		
		<input type="submit" value="저장하기">
	
	
	</form>




</body>
</html>
