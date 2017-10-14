<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>

<head>
<meta charset="UTF-8">
<title>健康アプリ_エラー</title>
<link rel="icon" type="image/png" href="resources/image/people.png">
<link rel="stylesheet" type="text/css" href="resources/css/layout.css">
<script type="text/javascript" src="resources/js/app.js"></script>
</head>

<body class="main">
	<h1>
		<img class="headericon" alt="入力" src="resources/image/icon_error.png">
		<c:out value="エラー画面" />
	</h1>
	<c:out value="${serverTime}" />
	<hr>
	<c:if test="${message == null}">
		<c:out value="入力情報に誤りがあります。もう一度入力してください" />
	</c:if>

	<c:out value="${message}" />

	<br><br>
	<img class="browseBack" alt="戻る" src="resources/image/icon_browseBack.jpg" onclick="history.back()">
</body>
</html>