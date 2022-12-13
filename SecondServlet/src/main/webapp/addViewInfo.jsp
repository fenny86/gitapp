<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>增加頁面</title>
</head>
<body>

		<form enctype="multipart/form-data" action="<c:url context='${pageContext.request.contextPath}' value='/addController'></c:url>" method="post">
		活動名稱:<input type="text" required="required" name="name"><br/>
		活動圖片:<input type="file" required="required" name="img"><br/>
		活動描述:<input type="text" required="required" name="description"><br/>
		活動開始時間:<input type="Date" required="required" name="start"><br/>
		活動結束時間:<input type="Date" required="required" name="end"><br/>
		活動地點:<input type="text" required="required" name="location"><br/>
		活動主辦單位:<input type="text" required="required" name="host"><br/>
		<input type="submit" value="新增"/><br/>
		</form>
		</body>
		</html>
<%@ include file="footer.jsp" %>