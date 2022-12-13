<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.Active"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顯示活動頁面</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> 
 <style>
        .table th {
            text-align: center;
        }
    </style>
</head>
<body>


<form class="form-inline my-2 my-lg-0" role="search" method="get" action="/Search/SearchList" target="_blank">
<div class="input-group">
<input type="text" class="form-control" name="keyword" placeholder="活動搜尋">
<span class="input-group-btn">
<button type="submit" class="btn btn-secondary">搜尋</button>
</span>
</div><!-- /input-group -->
</form>

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">活動編號</th>
      <th scope="col">活動名稱</th>
      <th scope="col">活動圖片</th>
      <th scope="col">活動描述</th>
      <th scope="col">活動開始時間</th>
      <th scope="col">活動結束時間</th>
      <th scope="col">活動地點</th>
      <th scope="col">活動主辦單位</th>
      <th scope="col">操作</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="active" items="${actives}">
    <tr>
      <th scope="row">${active.activeID}</th>
      <td>${active.activeName}</td>
      <td><img height='100' width='80' src="<c:url  value='/toImage?id=${active.activeID}'/>"></td>
      <td>${active.activeDescription}</td>
      <td>${active.activeStartDate}</td>
      <td>${active.activeEndDate}</td>
      <td>${active.activeLocation}</td>
      <td>${active.activeHost}</td>
      	<td><a href="<c:url context='${pageContext.request.contextPath}' value='/removeActiveController?id=${active.activeID}'></c:url>">刪除</a>&nbsp
	<a href="<c:url context='${pageContext.request.contextPath}' value='/showActiveController?id=${active.activeID}'></c:url>">修改</a></td>
    </tr>
 </c:forEach>
 <tr>
 <td colspan="6">
 <a href="<c:url context='${pageContext.request.contextPath}' value='/showAllActiveController?pageIndex=1'></c:url>">首頁</a>
 <c:if test="${page.pageIndex>11}">
  <a href="<c:url context='${pageContext.request.contextPath}' value='/showAllActiveController?pageIndex=${page.pageIndex -1}'></c:url>">上一頁</a>
 </c:if>
  <c:if test="${page.pageIndex==1}">
  <a>上一頁</a>
 </c:if>
  <c:if test="${page.pageIndex<page.totalPage}">
 <a href="<c:url context='${pageContext.request.contextPath}' value='/showAllActiveController?pageIndex=${page.pageIndex +1}'></c:url>">下一頁</a>
 </c:if>
  <c:if test="${page.pageIndex==page.totalPage}">
   <a href="<c:url context='${pageContext.request.contextPath}' value='/showAllActiveController?pageIndex=${page.pageIndex -1}'></c:url>">上一頁</a>
 <a>下一頁</a>
 </c:if>
  <a href="<c:url context='${pageContext.request.contextPath}' value='/showAllActiveController?pageIndex=${page.totalPage}'></c:url>">尾頁</a>
 </td>
 </tr>
 
 <input type="button" value="新增" onclick="location.href='/Temple/addViewInfo.jsp'">
 
  </tbody>
</table>
</body>
</html>
<%@ include file="footer.jsp" %>