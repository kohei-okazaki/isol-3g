<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>

<head>
<meta charset="UTF-8">
<title>健康アプリ_入力画面</title>
<link rel="icon" type="image/png" href="resources/image/people.png">
<link rel="stylesheet" type="text/css" href="resources/css/layout.css">
<script type="text/javascript" src="resources/js/menu.js"></script>
</head>

<body class="main">

	<c:if test="${page == 0}">
		<h1>
			<img class="headericon" alt="入力" src="resources/image/icon_input.jpg">
			<c:out value="入力画面" />
		</h1>
	</c:if>
	<c:if test="${page == 1}">
		<h1 class="title">
			<img class="headericon" alt="確認" src="resources/image/icon_confirm.png">
			<c:out value="確認画面" />
		</h1>
	</c:if>

	<c:out value="${serverTime}" />
	<hr>
	<img class="browseBack" alt="戻る" src="resources/image/icon_browseBack.jpg" onclick="history.back()">
	<!-- 入力画面 -->
	<c:if test="${page == 0}">
	<div align="center">
		<p>身長と体重を入力して下さい</p>
	</div>
	<br>
	<div align="center">
		<form action="/isol/input-confirm.html" method="post">
			<c:out value="身長：" />
			<input type="text" name="height" size="6" required>
			<c:out value="cm" />
			<p class="attention"><c:out value="※半角数字で入力してください" /></p>
			<br><br>
			<c:out value="体重：" />
			<input type="text" name="weight" size="6" required>
			<c:out value="kg" />
			<p class="attention"><c:out value="※半角数字で入力してください" /></p>
			<br>
			<br>
			<table>
				<tr>
					<td><input type="submit" value="確認"></td>
					<td><c:out value="　　" /></td>
					<td><input type="reset" value="リセット"></td>
				</tr>
			</table>
		</form>
	</div>
	</c:if>

	<!-- 確認画面 -->
	<c:if test="${page == 1}">
	<br>
	<div align="center">
		<form action="/isol/menu.html" method="post">
			<c:out value="身長：" />
			<input type="text" name="height" value="${form.height}" size="6" disabled="disabled">
			<input type="hidden" name="height" value="${form.height}" />
			<c:out value="cm" />
			<br><br>
			<c:out value="体重：" />
			<input type="text" name="weight" value="${form.weight}" size="6" disabled="disabled">
			<input type="hidden" name="weight" value="${form.weight}" />
			<c:out value="kg" />
			<br><br>
			<table>
				<tr>
					<td><input type="submit" value="確定"></td>
				</tr>
			</table>
		</form>
	</div>
	</c:if>
	<hr>

	<img class="browseBack" alt="戻る" src="resources/image/icon_browseBack.jpg" onclick="history.back()">

</body>
</html>
