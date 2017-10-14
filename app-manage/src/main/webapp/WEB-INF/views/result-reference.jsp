<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>

<html>

<head>
<meta charset="UTF-8">
<title>健康アプリ_結果照会画面</title>
<link rel="icon" type="image/png" href="../resources/image/people.png">
<link rel="stylesheet" type="text/css" href="../resources/css/layout.css">
<script type="text/javascript" src="../resources/js/app.js"></script>
</head>

<body class="main">
	<h1>
		<img class="headericon" alt="入力" src="../resources/image/icon_reference.png">
		<c:out value="結果照会画面" />
	</h1>
	<div>
		<c:out value="${serverTime}" />
	</div>

	<hr>
	<img class="browseBack" alt="戻る" src="../resources/image/icon_browseBack.jpg" onclick="history.back()">
	<br><br>
	<div align="center">
		<table border="1">
			<tr class="headercolor">
				<th align="center"><c:out value="身長" /></th>
				<th align="center"><c:out value="体重" /></th>
				<th align="center"><c:out value="標準体重" /></th>
				<th align="center"><c:out value="BMI" /></th>
			</tr>
			<c:forEach var="result" items="${allDataList}">
				<tr class="datacolor">
					<td align="center"><c:out value="${result.height}" /></td>
					<td align="center"><c:out value="${result.weight}" /></td>
					<td align="center"><c:out value="${result.standardWeight}" /></td>
					<td align="center"><c:out value="${result.bmi}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br><br>
	<hr>

	<img class="browseBack" alt="戻る" src="../resources/image/icon_browseBack.jpg" onclick="history.back()">

</body>
</html>