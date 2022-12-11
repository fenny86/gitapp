<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增寺廟資料</title>
<style>
form {
	margin: 0 auto;
	width: 600px;
}
</style>
</head>
<body onload="javascript:document.insertMemberFormA.mId.focus();">
	<form name="insertMemberFormA" action="<c:url value='/ch04_01/member.do'  />" method="POST">
		<table border="1">
			<thead>
				<tr bgcolor='tan'>
					<th height="60" colspan="2" align="center" ><h2>新增寺廟資料</h2></th>
				</tr>
			</thead>
			<tbody>
				<tr bgcolor='tan'>
					<td width="120" height="40">編號:</td>
					<td width="600" height="40" align="left"><input id='memberId'
						style="text-align: left" name="memberId" type="text" size="14">
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">寺廟名稱:</td>
					<td width="600" height="40" align="left"><input id='pswd'
						style="text-align: left" name="pswd" type="password" size="14">
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">主祀神:</td>
					<td width="600" height="40" align="left"><input name="name"
						type="text" size="20"></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">行政區:</td>
					<td width="600" height="40" align="left"><input name="phone"
						type="text" size="20"></td>
				</tr>
				
				<tr bgcolor='tan'>
					<td width="120" height="40">地址:</td>
					<td width="600" height="40" align="left"><input name="phone"
						type="text" size="20"></td>
				</tr>

				<tr bgcolor='tan'>
					<td width="120" height="40">登記別:</td>
					<td width="600" height="40" align="left"><input name="weight"
						type="text" size="14"></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">教別:</td>
					<td width="600" height="40" align="left"><input name="weight"
						type="text" size="14"></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">電話:</td>
					<td width="600" height="40" align="left"><input name="weight"
						type="text" size="14"></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">負責人:</td>
					<td width="600" height="40" align="left"><input name="weight"
						type="text" size="14"></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">其他:</td>
					<td width="600" height="40" align="left"><input name="weight"
						type="text" size="14"></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">X座標:</td>
					<td width="600" height="40" align="left"><input name="weight"
						type="text" size="14"></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">Y座標:</td>
					<td width="600" height="40" align="left"><input name="weight"
						type="text" size="14"></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">統一編號:</td>
					<td width="600" height="40" align="left"><input name="weight"
						type="text" size="14"></td>
				</tr>
				<tr bgcolor='tan'>
					<td height="50" colspan="2" align="center"><input
						type="submit" value="送出"></td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>