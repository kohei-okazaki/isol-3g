<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>

<head>
<meta charset="UTF-8">
<title>健康アプリ_アカウント設定画面</title>
<link rel="icon" type="image/png" href="resources/image/people.png">
<link rel="stylesheet" type="text/css" href="resources/css/layout.css">
<script type="text/javascript" src="resources/js/app.js"></script>
</head>

<body class="main">

	<c:if test="${page == 0}">
		<h1>
			<img class="headericon" alt="入力" src="resources/image/icon_input.jpg">
			<c:out value="アカウント設定画面" />
		</h1>
	</c:if>
	<c:if test="${page == 1}">
		<h1 class="title">
			<img class="headericon" alt="確認" src="resources/image/icon_confirm.png">
			<c:out value="アカウント設定確認画面" />
		</h1>
	</c:if>
	<c:if test="${page == 2}">
		<h1 class="title">
			<img class="headericon" alt="確認" src="resources/image/icon_confirm.png">
			<c:out value="アカウント設定完了画面" />
		</h1>
	</c:if>

	<hr>
		<ul id="dropmenu">
		<li><a href="#">MENU</a>
			<ul>
				<li><a href="#">ユーザ情報</a>
					<ul>
						<li><a href="/isol-manage/healthInfo-input.html">入力</a></li>
						<li><a href="/isol-manage/result-reference.html">照会</a></li>
					</ul>
				</li>
				<li><a href="/isol-manage/menu.html">メニュー戻る</a></li>
			</ul>
		</li>
		<li><a href="#">設定</a>
			<ul>
				<li><a href="#">出力設定</a></li>
				<li><a href="#">アカウント</a>
					<ul>
						<li><a href="/isol-manage/account-setting-input.html">設定変更</a></li>
					</ul>
				</li>
			</ul>
		</li>
		<li><a href="/isol-manage/login.html"> ログアウト </a></li>
	</ul>

	<br><br>

	<!-- 入力画面 -->
	<c:if test="${page == 0}">
		<form action="/isol-manage/account-setting-confirm.html" method="post">
		<div align="center">

			<c:if test="${errorMessage != null}">
				<c:out value="${errorMessage}" />
			</c:if>
			<table border="1">

				<tr>
					<th width="130px"><c:out value="削除" /></th>
					<td width="250px">
						<div class="radio">
							<input type="radio" name="deleteFlag" id="true" value="1" checked="checked">
							<label for="true">する</label>
							<input type="radio" name="deleteFlag" id="false" value="0">
							<label for="false" class="switch-off">しない</label>
						</div>
					</td>
				</tr>
				<tr>
					<th><c:out value="ユーザID" /></th>
					<td><input type="text" name="userId" value="${dto.userId}" disabled="disabled" /></td>
				</tr>
				<tr>
					<th><c:out value="パスワード" /></th>
					<td><input type="text" name="password" value="${dto.password}" required="required" /></td>
				</tr>
			</table>
			<br><br>
			<table>
				<tr>
					<td><input type="submit" value="確 認" /></td>
				</tr>
			</table>
		</div>
		</form>
	</c:if>

	<!-- 確認画面 -->
	<c:if test="${page == 1}">
		<form action="/isol-manage/account-setting-complete.html" method="post">
		<div align="center">
			<table border="1">
				<tr>
					<th width="130px"><c:out value="削除" /></th>
					<td width="250px">
						<c:if test="${form.deleteFlag == true}">する</c:if>
						<c:if test="${form.deleteFlag == false}">しない</c:if>
					</td>
				</tr>
				<tr>
					<th><c:out value="ユーザID" /></th>
					<td><input type="text" name="userId" value="${form.userId}" disabled="disabled" /></td>
				</tr>
				<tr>
					<th><c:out value="パスワード" /></th>
					<td><input type="text" name="password" value="${form.password}" disabled="disabled" /></td>
				</tr>
			</table>
			<br><br>
			<table>
				<tr>
					<td><input type="submit" value="確 定" /></td>
					<td><c:out value="　　" /></td>
					<td><input type="button" value="戻 る" onclick="history.back()"></td>
				</tr>
			</table>
		</div>
		</form>
	</c:if>

	<!-- 完了画面 -->
	<c:if test="${page == 2}">
		<div align="center">
			<c:out value="完了しました" />
			<br><br>
			<table>
				<tr>
					<td align="center">
						<!-- メニュー画面へ -->
						<form action="/isol-manage/menu.html" method="get">
							<div>
								<input class="menuicon" type="image" src="resources/image/icon_menu.jpg">
							</div>
						</form>
					</td>
				</tr>
			</table>
		</div>
	</c:if>




	<br><br>
	<hr>

	<img class="browseBack" alt="戻る" src="resources/image/icon_browseBack.jpg" onclick="history.back()">

</body>
</html>