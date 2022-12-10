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
		活動名稱:<input type="text" name="name" value=""><br/>
		活動圖片:<input type="file" name="img" value=""><br/>
		活動描述:<input type="text" name="description" value=""><br/>
		活動開始時間:<input type="text" name="start" value=""><br/>
		活動結束時間:<input type="text" name="end" value=""><br/>
		活動地點:<input type="text" name="location" value=""><br/>
		活動主辦單位:<input type="text" name="host" value=""><br/>
		<input type="submit" value="新增"/><br/>
		</form>
		</body>
		</html>
</body>
</html>
<%@ include file="footer.jsp" %>