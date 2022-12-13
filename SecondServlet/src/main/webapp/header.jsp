<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> 

</head>
<body>
<header>
  <header>
  <!-- Intro settings -->
  <style>
    /* Default height for small devices */
    #intro-example {
      height: 400px;
    }

    /* Height for devices larger than 992px */
    @media (min-width: 992px) {
      #intro-example {
        height: 600px;
      }
    }
  </style>

  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
    <div class="container-fluid">
      <button
        class="navbar-toggler"
        type="button"
        data-mdb-toggle="collapse"
        data-mdb-target="#navbarExample01"
        aria-controls="navbarExample01"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarExample01">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item active">
            <a class="nav-link" aria-current="page" href="http://localhost:8080/SecondServlet/index.html">主頁</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="http://localhost:8080/SecondServlet/accountLogin.html">登錄畫面</a>
          </li>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="http://localhost:8080/SecondServlet/controller/classShoppingList">線上課程</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="http://localhost:8080/SecondServlet/JSP/homepage.jsp">討論區</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="http://localhost:8080/SecondServlet/EEIT56_23/index_23.jsp">月老牽紅線</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="http://localhost:8080/SecondServlet/showAllActiveController">活動頁面</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <!-- Navbar -->

  <!-- Background image -->
  <div
    id="intro-example"
    class="p-5 text-center bg-image"
    style="background-image: url('img/lor.webp');"
  >
    <div class="mask" style="background-color: rgba(0, 0, 0, 0.7);">
      <div class="d-flex justify-content-center align-items-center h-100">
        <div class="text-white">
          <h1 class="mb-3">這是宗教網站</h1>
          <h5 class="mb-4">一起來信教吧</h5>
          <a
            class="btn btn-outline-light btn-lg m-2"
            href="https://www.youtube.com/watch?v=E92tUFQVQqo"
            role="button"
            rel="nofollow"
            target="_blank"
          >開始信教</a
          >
          <a
            class="btn btn-outline-light btn-lg m-2"
            href="https://mdbootstrap.com/docs/standard/"
            target="_blank"
            role="button"
          >好邪門我不要</a
          >
        </div>
      </div>
    </div>
  </div>
  <!-- Background image -->
</header>





</html>