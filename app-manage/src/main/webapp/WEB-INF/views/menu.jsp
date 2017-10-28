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
<script type="text/javascript" src="resources/js/app.js"></script>
</head>

<body class="main">
	<h1>
		<img class="headericon" alt="入力" src="resources/image/icon_menu.jpg">
		<c:out value="メニュー画面" />
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
						<li><a href="#">孫メニュー2</a></li>
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
							</ul></li>
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
			</ul>
		</li>
		<li><a href="#">設定</a>
			<ul>
				<li><a href="/isol/account-setting-input.html">アカウント設定</a></li>
				<li><a href="#">出力設定</a></li>
			</ul>
		</li>
		<li><a href="/isol/login.html"> ログアウト </a></li>
	</ul>

	<img class="browseBack" alt="戻る" src="resources/image/icon_browseBack.jpg" onclick="history.back()">
	<c:if test="${page == 2}">
		<c:out value="完了しました" />
	</c:if>
	<div align="center">
		<c:out value="今のあなたの身長(${dto.height}cm)の" />
		<br>
		<c:out value="標準体重は${dto.standardWeight}kgです。" />
		<br>
		<c:out value="前回より${diffWeight}kg ${resultMessage}" />
		<br>
		<c:out value="${beforeWeight}kg→${dto.weight}kg" />
		<br><br><br>
		<table class="custom">
			<tr class="headercolor">
				<th align="center"><c:out value="標準体重" /></th>
				<th align="center"><c:out value="BMI" /></th>
			</tr>
			<tr class="datacolor">
				<td align="center"><c:out value="${dto.standardWeight}" /></td>
				<td align="center"><c:out value="${dto.bmi}" /></td>
			</tr>
		</table>
		<br><br><br>
		<table>
			<tr>
				<td align="center">
				<!-- 通知  -->
					<form action="/isol/menu/notice.html" method="post">
						<input type="hidden" name="height" value="${dto.height}">
						<input type="hidden" name="weight" value="${dto.weight}">
						<input type="hidden" name="standardWeight" value="${dto.standardWeight}">
						<input type="hidden" name="bmi" value="${dto.bmi}">
						<div>
							<input class="menuicon" type="image" src="resources/image/icon_mail.png">
						</div>
					</form>
				</td>
				<td>　　</td>
				<td align="center">
				<!-- 出力 -->
					<form action="/isol/menu/fileDownload.html" method="get">
						<input type="hidden" name="height" value="${dto.height}">
						<input type="hidden" name="weight" value="${dto.weight}">
						<input type="hidden" name="standardWeight" value="${dto.standardWeight}">
						<input type="hidden" name="bmi" value="${dto.bmi}">
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