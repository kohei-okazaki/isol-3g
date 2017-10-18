<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>

<html>

<head>
<meta charset="UTF-8">
<title>健康アプリ_アカウント設定画面</title>
<link rel="icon" type="image/png" href="resources/image/people.png">
<link rel="stylesheet" type="text/css" href="resources/css/layout.css">
<script type="text/javascript" src="resources/js/app.js"></script>
</head>

<body class="main">
	<h1>
		<img class="headericon" alt="アカウント設定" src="resources/image/icon_reference.png">
		<c:out value="アカウント設定画面" />
	</h1>
	<div>
		<c:out value="${serverTime}" />
	</div>
	<hr>
	<img class="browseBack" alt="戻る" src="resources/image/icon_browseBack.jpg" onclick="history.back()">
	<br><br>

	<!-- 入力画面 -->
	<c:if test="${page == 0}">
		<form action="/isol/account-setting-confirm.html" method="post">
			<table border="1">
				<tr>
					<td><c:out value="ID" /></td>
					<td><c:out value="${id}" /></td>
				</tr>
			</table>
		</form>
	</c:if>








	<br><br>
	<hr>

	<img class="browseBack" alt="戻る" src="resources/image/icon_browseBack.jpg" onclick="history.back()">

</body>
</html>