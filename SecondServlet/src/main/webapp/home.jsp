<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>登錄頁面</title>
<link rel="stylesheet" href="assets/css/styles.css" />
</head>
<body>
	<jsp:include page="/fragment/topMVC.jsp" />

<a href="<c:url value='/controller/classShoppingList' />">點進來就是課程總覽</a><p/>

</body>
</html>