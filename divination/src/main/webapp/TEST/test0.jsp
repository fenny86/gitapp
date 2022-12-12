<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<Form action="<c:url value='/test1"' />" method="POST" name="loginForm">
<%-- 	<Form action="<c:url value='/test1?car=${tesla}"' />" method="POST" name="loginForm"> --%>
<!-- 		<input type="text" name="car"> -->
		 <input type="submit"> 
<!-- 		name決定 String s=request.getParameter("car"); -->
	</Form>
</body>
</html>