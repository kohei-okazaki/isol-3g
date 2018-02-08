<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
<meta charset="UTF-8">
</head>
<body>
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
						<li><a href="/isol-manage/account-setting-input.html">設定変更</a></li>
					</ul>
				</li>
			</ul>
		</li>
		<li><a href="/isol-manage/login.html">ログアウト</a></li>
	</ul>
</body>
</html>