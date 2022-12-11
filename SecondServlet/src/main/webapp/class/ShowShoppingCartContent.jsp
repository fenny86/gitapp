<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server 
response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance 
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale" 
response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
%>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>查詢頁面</title>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src="https://kit.fontawesome.com/f7498d7580.js"
	crossorigin="anonymous"></script>
<style>
table, h1 {
	text-align: center;
}
</style>
<script type="text/javascript">
function confirmDelete(n) {
	if (confirm("確定刪除此項商品 ? ") ) {
		document.forms[0].action="<c:url value='/UpdateItem.do?cmd=DEL&classNumber=" + n +"' />" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
	
	}
}
function modify(key, qty, index) {
	var x = "newQty" + index;
	var newQty = document.getElementById(x).value;
	if  (newQty < 0 ) {
		window.alert ('數量不能小於 0');
		return ; 
	}
	if  (newQty == 0 ) {
		window.alert ("請執行刪除功能來刪除此項商品");
		document.getElementById(x).value = qty;
		return ; 
	}
	if  (newQty == qty ) {
		window.alert ("新、舊數量相同，不必修改");
		return ; 
	}
	if (confirm("確定將此商品的數量由" + qty + " 改為 " + newQty + " ? ") ) {
		document.forms[0].action="<c:url value='/UpdateItem.do?cmd=MOD&classNumber=" + key + "&newQty=" + newQty +"' />" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
		document.getElementById(x).value = qty;
	}
}
function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode > 31 && (charCode < 48 || charCode > 57)){
      return false;
   }
   return true;
}
function Checkout(qty) {
	if (qty == 0)  {
		alert("無購買任何商品，不需結帳");
		return false;
	}
	if (confirm("再次確認訂單內容 ? ") ) {
		return true;
	} else {
		return false;
	}
}
function Abort() {
	if (confirm("確定放棄購物 ? ") ) {
		return true;
	} else {
		return false;
	}
}

</script>
</head>

<body>
	<c:set var="funcName" value="CHE" scope="session" />
	<jsp:include page="/fragment/topMVC.jsp" />

	<c:choose>
		<c:when test="${shoppingCart.getSubtotal() > 0}">
			<c:set var="subtotalMessage"
				value="金額小計:${shoppingCart.getSubtotal()} 元" />
			<c:set var="subtotal" value="${shoppingCart.getSubtotal()}" />
		</c:when>
		<c:otherwise>
			<!-- 購物車內沒有商品 -->
			<c:set var="cartContent" value="您尚未購買任何商品" />
		</c:otherwise>
	</c:choose>


	<%-- 	         <span>購入商品總數量:${shoppingCart.getQty()}</span> --%>
	<%--          <span>金額小計(OK):<c:out value="${shoppingCart.getSubtotal()}" default="0"/> 元</span> --%>
	<%--          <span>金額小計(OK):<c:out value="${shoppingCart.getContent()}" default="0"/> 元</span> --%>
	<%--               <a href="<c:url value='/abort.do' />" onClick="return Abort();">放棄購物</a> --%>
	<!-- 	<header> -->
	<h1>結帳總額</h1>
	</header>
	<table id="table_id" class="display">
		<thead>
			<tr>
				<th>課程名稱</th>
				<th>課程圖片</th>
				<th>課程數量</th>
				<th>課程價錢</th>
				<th>課程金額</th>
				<th>請再次確認</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="anEntry" items="${shoppingCart.getContent()}">
				<tr>
					<td>${anEntry.value.description}</td>
					<td><img height='100' width='80'
						src="<c:url value='/controller/classImage?id=${anEntry.value.classNumber}' />"></td>
					<td>${anEntry.value.quantity}</td>
					<td>${anEntry.value.unitPrice}</td>
					<td>${anEntry.value.unitPrice*anEntry.value.quantity}</td>

					<td><Input type="submit" name="delete" value="刪除"
						onclick="confirmDelete(${anEntry.key})"> <Input
						type="button" name="update" value="修改"
						onclick="modify(${anEntry.key}, ${anEntry.value.quantity}, ${vs.index})">
					</td>
				</tr>
			</c:forEach>
		</tbody>

		<td colspan='5' style='text-align: right'>總計金額：${shoppingCart.getSubtotal() }</td>
		<td colspan='5' style='text-align: right'><a
			href="<c:url value='/class/OrderConfirm.jsp' />"
			onClick="return Checkout(${shoppingCart.getSubtotal()});">再次確認</a></td>

	</table>

	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
	<script>
		
		$(document).ready(function() {
			$('#table_id').DataTable();
		});
		
	</script>
</body>

</html>