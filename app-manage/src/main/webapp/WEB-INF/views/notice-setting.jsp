<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>

<head>
<meta charset="UTF-8">
<title>健康アプリ_通知設定画面</title>
<link rel="icon" type="image/png" href="resources/image/people.png">
<link rel="stylesheet" type="text/css" href="resources/css/layout.css">
<script type="text/javascript" src="resources/js/app.js"></script>
</head>

<body class="main">
	<h1>
		<img class="headericon" alt="入力" src="resources/image/icon_reference.png">
		<c:out value="通知設定画面" />
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
				<li><a href="/isol/menu.html">メニュー画面</a></li>
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
	<br><br>






	<br><br>
	<hr>

	<img class="browseBack" alt="戻る" src="resources/image/icon_browseBack.jpg" onclick="history.back()">

</body>
</html>