<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>

<head>
<meta charset="UTF-8">
<title>健康アプリ_メニュー画面</title>
<link rel="icon" type="image/png" href="resources/image/people.png">
<link rel="stylesheet" type="text/css" href="resources/css/layout.css">
<link rel="stylesheet" type="text/css" href="resources/css/navigation.css">
<link rel="stylesheet" type="text/css" href="resources/css/common/headericon.css">
<script type="text/javascript" src="resources/js/common/common.js"></script>
</head>

<body class="main">
	<h1>
		<img class="headericon" alt="入力" src="resources/image/icon_menu.jpg">
		<c:out value="メニュー画面" />
	</h1>

	<hr>
	<jsp:include page="/WEB-INF/views/common/navigation.jsp" />


	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<hr>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

</body>
</html>