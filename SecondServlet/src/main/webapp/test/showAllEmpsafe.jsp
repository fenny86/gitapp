<%@page import="test.Emp"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢所有員工</title>
</head>
<body>
<table border="1">
	<tr>
	<td>編號</td>
	<td>姓名</td>
	<td>工資</td>
	<td>年齡</td>
	<td colspan="2">操作</td>
	</tr>
	<%
	List<Emp> emps=(List<Emp>)request.getAttribute("emps");
	for(Emp emp:emps){
		%>
	<tr>
	<td><%=emp.getId() %></td>
	<td><%=emp.getName() %></td>
	<td><%=emp.getSalary() %></td>
	<td><%=emp.getAge() %></td>
	<td><a href="<%=request.getContextPath()+"/removeEmpControllersafe?id="+emp.getId() %>">刪除</a></td>
	<td><a href="<%=request.getContextPath()+"/showEmpControllersafe?id="+emp.getId() %>">修改</a></td>
	
	</tr>
	
	
	<% 
	}
	%>

</table>
</body>
</html>