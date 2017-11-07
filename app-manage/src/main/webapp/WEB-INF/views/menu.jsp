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
				<li><a href="#">ユーザ情報</a>
					<ul>
						<li><a href="/isol-manage/input.html">入力</a></li>
						<li><a href="/isol-manage/result-reference.html">照会</a></li>
					</ul>
				</li>
				<li><a href="#">通知</a>
					<ul>
						<li><a href="/isol-manage/notice.html">メール</a></li>
					</ul>
				</li>
			</ul>
		</li>
		<li><a href="#">設定</a>
			<ul>
				<li><a href="#">出力設定</a></li>
				<li><a href="#">アカウント</a>
					<ul>
						<li><a href="/isol-manage/account-create-input.html">新規作成</a></li>
						<li><a href="/isol-manage/account-setting-input.html">設定変更</a></li>
					</ul>
				</li>
			</ul>
		</li>
		<li><a href="/isol-manage/login.html">ログアウト</a></li>
	</ul>

	<img class="browseBack" alt="戻る" src="resources/image/icon_browseBack.jpg" onclick="history.back()">


	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<hr>
	<img class="browseBack" alt="戻る" src="resources/image/icon_browseBack.jpg" onclick="history.back()">

</body>
</html>