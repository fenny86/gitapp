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
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>顯示活動頁面</title>
 <style>
    table {
      text-align: center;
    }
  </style>
  <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
</head>
<body>
<body>
 <div class="container">
  <h1>Employee Register Form:</h1>
  <div class="card">
   <div class="card-body">
    <form action="<%=request.getContextPath()%>/register" method="post">

     <div class="form-group row">
      <label for="firstName" class="col-sm-2 col-form-label">First
       Name</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="firstName"
        placeholder="Enter first name">
      </div>
     </div>

     <div class="form-group row">
      <label for="lastName" class="col-sm-2 col-form-label">Last
       Name</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="lastName"
        placeholder="Enter last name">
      </div>
     </div>

     <div class=" form-group row">
      <label for="lastName" class="col-sm-2 col-form-label">User
       Name</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="username"
        placeholder="Enter user name">
      </div>
     </div>

     <div class="form-group row">
      <label for="lastName" class="col-sm-2 col-form-label">Passwrod</label>
      <div class="col-sm-7">
       <input type="password" class="form-control" name="password"
        placeholder="Enter Password">
      </div>
     </div>

     <div class="form-group row">
      <label for="lastName" class="col-sm-2 col-form-label">Address</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="address"
        placeholder="Enter Address">
      </div>
     </div>

     <div class="form-group row">
      <label for="contact" class="col-sm-2 col-form-label">Contact
       No</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="contact"
        placeholder="Enter Contact Address">
      </div>
     </div>

     <button type="submit" class="btn btn-primary">Submit</button>
    </form>
   </div>
  </div>
 </div>
</body>
</body>
</html>
<%@ include file="footer.jsp" %>