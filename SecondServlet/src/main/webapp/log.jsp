<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>登錄頁面</title>
  </head>
  <body>
    <form action="<c:url value='/accountLogin'/>" method="post">
      帳號:<input type="text" name="username" /><br />
      密碼:<input type="password" name="password" /><br />
      <input type="submit" value="登錄" />
    </form>
  </body>
</html>