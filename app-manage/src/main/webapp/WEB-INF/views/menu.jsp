<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>

<html>

<head>
<meta charset="UTF-8">
<title>健康アプリ_メニュー画面</title>
<link rel="icon" type="image/png" href="resources/image/people.png">
<link rel="stylesheet" type="text/css" href="resources/css/layout.css">
<script type="text/javascript" src="resources/js/app.js"></script>
</head>

<body class="main">
	<h1>
		<img class="headericon" alt="入力" src="resources/image/icon_menu.jpg">
		<c:out value="メニュー画面" />
	</h1>
	<c:out value="${serverTime}" />
	<hr>
	<header class="menu">
	<ul>
		<li>
			<a href="#"> 設定  <span>▼</span></a>
			<ul>
				<li><a href="/isol/account-setting.html"> アカウント設定 </a></li>
				<li><a href="/isol/notice-setting.html"> 各通知設定 </a></li>
			</ul>
		</li>
		<li><a href="#"> Menu02 </a></li>
		<li><a href="#"> Menu03 </a></li>
		<li><a href="/isol/login.html"> ログアウト </a></li>
	</ul>
	</header>
	<hr>
	<img class="browseBack" alt="戻る" src="resources/image/icon_browseBack.jpg" onclick="history.back()">
	<c:if test="${page == 2}">
		<c:out value="完了しました" />
	</c:if>
	<div align="center">
		<c:out value="今のあなたの身長(${form.height}cm)の" />
		<br>
		<c:out value="標準体重は${standardWeight}kgです。" />
		<br>
		<c:out value="前回より${diffWeight}kg ${resultMessage}" />
		<br>
		<c:out value="${beforeWeight}kg→${form.weight}kg" />
		<br><br><br>
		<table class="custom">
			<tr class="headercolor">
				<th align="center"><c:out value="標準体重" /></th>
				<th align="center"><c:out value="BMI" /></th>
			</tr>
			<tr class="datacolor">
				<td align="center"><c:out value="${standardWeight}" /></td>
				<td align="center"><c:out value="${bmi}" /></td>
			</tr>
		</table>
		<br><br><br>
		<table>
			<tr>
				<td align="center">
				<!-- 通知  -->
					<form action="/isol/menu/notice.html" method="post">
						<input type="hidden" name="height" value="${form.height}">
						<input type="hidden" name="weight" value="${form.weight}">
						<input type="hidden" name="standardWeight" value="${standardWeight}">
						<input type="hidden" name="bmi" value="${bmi}">
						<div>
							<input class="menuicon" type="image" src="resources/image/icon_mail.png">
						</div>
					</form>
				</td>
				<td>　　</td>
				<td align="center">
				<!-- 出力 -->
					<form action="/isol/menu/fileDownload.html" method="get">
						<input type="hidden" name="height" value="${form.height}">
						<input type="hidden" name="weight" value="${form.weight}">
						<input type="hidden" name="standardWeight" value="${standardWeight}">
						<input type="hidden" name="bmi" value="${bmi}">
						<div>
							<input class="menuicon" type="image" src="resources/image/icon_xlsx.png">
						</div>
					</form>
				</td>
				<td>　　</td>
				<td align="center">
				<!-- 結果照会 -->
					<form action="/isol/menu/result-reference.html" method="post">
						<div>
							<input class="menuicon" type="image" src="resources/image/icon_reference.png">
						</div>
					</form>
				</td>
			</tr>
		</table>
	</div>
	<hr>

	<img class="browseBack" alt="戻る" src="resources/image/icon_browseBack.jpg" onclick="history.back()">

</body>
</html>