<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>

<head>
<meta charset="UTF-8">
<title>健康アプリ_結果照会画面</title>
<link rel="icon" type="image/png" href="resources/image/people.png">
<link rel="stylesheet" type="text/css" href="resources/css/layout.css">
<script type="text/javascript" src="resources/js/app.js"></script>
</head>

<body class="main">
	<h1>
		<img class="headericon" alt="結果照会" src="resources/image/icon_reference.png">
		<c:out value="結果照会画面" />
	</h1>
	<hr>

	<ul id="dropmenu">
		<li><a href="#">MENU</a>
			<ul>
				<li><a href="#">ユーザ情報</a>
					<ul>
						<li><a href="/isol-manage/input.html">入力</a></li>
					</ul>
				</li>
				<li><a href="#">通知</a>
					<ul>
						<li><a href="/isol-manage/notice.html">メール</a></li>
					</ul>
				</li>
				<li><a href="/isol-manage/menu.html">メニュー戻る</a></li>
			</ul>
		</li>
		<li><a href="#">ダウンロード</a>
			<ul>
				<li><a onclick="referenceExcelDownload();">エクセル</a></li>
				<li><a href="#">テキストファイル</a></li>
			</ul>
		</li>
		<li><a href="#">設定</a>
			<ul>
				<li><a href="#">出力設定</a></li>
				<li><a href="#">アカウント</a>
					<ul>
						<li><a href="/isol-manage/account-setting-input.html">設定変更</a></li>
						<li><a href="#">新規作成</a></li>
					</ul>
				</li>
			</ul>
		</li>
		<li><a href="/isol-manage/login.html">ログアウト</a></li>
	</ul>

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
			<c:forEach var="result" items="${resultList}">
				<tr class="datacolor">
					<td align="center"><c:out value="${result.height}" /></td>
					<td align="center"><c:out value="${result.weight}" /></td>
					<td align="center"><c:out value="${result.standardWeight}" /></td>
					<td align="center"><c:out value="${result.bmi}" /></td>
					<td align="center"><c:out value="${result.regDate}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br><br>

	<hr>

	<img class="browseBack" alt="戻る" src="resources/image/icon_browseBack.jpg" onclick="history.back()">

</body>
</html>