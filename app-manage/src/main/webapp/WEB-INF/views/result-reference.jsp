<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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

	<hr>
		<ul id="dropmenu">
		<li><a href="#">MENU</a>
			<ul>
				<li><a href="#">子メニュー1</a>
					<ul>
						<li><a href="#">孫メニュー1</a>
							<ul>
								<li><a href="#">ひ孫メニュー1</a></li>
								<li><a href="#">ひ孫メニュー2</a></li>
							</ul>
						</li>
						<li>
							<a href="#">孫メニュー2</a>
						</li>
					</ul>
				</li>
				<li><a href="#">子メニュー2</a>
					<ul>
						<li><a href="#">孫メニュー1</a></li>
						<li><a href="#">孫メニュー2</a></li>
						<li><a href="#">孫メニュー3</a></li>
						<li><a href="#">孫メニュー4</a></li>
					</ul>
				</li>
				<li><a href="#">子メニュー3</a>
					<ul>
						<li><a href="#">孫メニュー1</a></li>
						<li><a href="#">孫メニュー2</a></li>
						<li><a href="#">孫メニュー3</a>
							<ul>
								<li><a href="#">ひ孫メニュー</a></li>
							</ul>
						</li>
						<li><a href="#">孫メニュー4</a></li>
					</ul>
				</li>
				<li><a href="#">子メニュー4</a>
					<ul>
						<li><a href="#">孫メニュー1</a></li>
						<li><a href="#">孫メニュー2</a></li>
						<li><a href="#">孫メニュー3</a></li>
						<li><a href="#">孫メニュー4</a></li>
					</ul>
				</li>
				<li>
					<a href="/isol/menu.html">メニュー画面</a>
				</li>
			</ul>
		</li>
		<li><a href="#">設定</a>
			<ul>
				<li><a href="/isol/account-setting-input.html">アカウント設定</a></li>
				<li><a href="#">出力設定</a></li>
			</ul>
		</li>
		<li>
			<a href="/isol/login.html"> ログアウト </a>
		</li>
	</ul>

	<img class="browseBack" alt="戻る" src="../resources/image/icon_browseBack.jpg" onclick="history.back()">
	<br><br>
	<div align="center">
		<table border="1">
			<tr class="headercolor">
				<th align="center"><c:out value="身長" /></th>
				<th align="center"><c:out value="体重" /></th>
				<th align="center"><c:out value="標準体重" /></th>
				<th align="center"><c:out value="BMI" /></th>
				<th align="center"><c:out value="登録日時" /></th>
			</tr>
			<c:forEach var="result" items="${allDataList}">
				<tr class="datacolor">
					<td align="center"><c:out value="${result.height}" /></td>
					<td align="center"><c:out value="${result.weight}" /></td>
					<td align="center"><c:out value="${result.standardWeight}" /></td>
					<td align="center"><c:out value="${result.bmi}" /></td>
					<td align="center"><c:out value="${result.recordDate}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br><br>
	<table>
		<tr>
			<td>
				<form action="/isol/menu/result-reference-download.html" method="get">
					<div align="center">
						<input class="menuicon" type="image" src="../resources/image/icon_xlsx.png">
					</div>
				</form>
			</td>
		</tr>
	</table>
	<hr>

	<img class="browseBack" alt="戻る" src="../resources/image/icon_browseBack.jpg" onclick="history.back()">

</body>
</html>