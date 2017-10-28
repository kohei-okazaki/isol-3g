<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta charset="UTF-8">
<title>健康管理アプリ_ログイン画面</title>
<link rel="icon" type="image/png" href="resources/image/people.png">
<link rel="stylesheet" type="text/css" href="resources/css/loginLayout.css">
<script type="text/javascript" src="resources/js/app.js"></script>
</head>
<body>
<c:if test="${errorMessage != null}">
	<div align="center"><c:out value="${errorMessage}" /></div>
</c:if>
	<fieldset>
		<h1>健康管理アプリ</h1>
		<form action="/isol/input.html" method="post">
			<div class="iconUser"></div>
			<input type="text" name="id" placeholder="ID" required>
			<br><br>
			<div class="iconPassword"></div>
			<input type="password" name="password" placeholder="パスワード" required>
			<input type="submit" value="ログイン">
		</form>
	</fieldset>
</body>
</html>
