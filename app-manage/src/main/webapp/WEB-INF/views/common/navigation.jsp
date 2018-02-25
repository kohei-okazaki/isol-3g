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
	<ul id="dropmenu">
		<li><a class="navigation" href="#">MENU</a>
			<ul>
				<li><a class="navigation" href="#">ユーザ情報</a>
					<ul>
						<li><a class="navigation" href="/isol-manage/healthInfo-input.html">入力</a></li>
						<li><a class="navigation" href="/isol-manage/result-reference.html">照会</a></li>
					</ul>
				</li>
				<li><a class="navigation" href="#">通知</a>
					<ul>
						<li><a class="navigation" href="/isol-manage/notice.html">メール</a></li>
					</ul>
				</li>
			</ul>
		</li>
		<li><a class="navigation" href="#">設定</a>
			<ul>
				<li><a class="navigation" href="#">アカウント</a>
					<ul>
						<li><a class="navigation" href="/isol-manage/account-setting-input.html">設定変更</a></li>
					</ul>
				</li>
				<li><a class="navigation" href="#">メール設定</a></li>
			</ul>
		</li>
		<li><a class="navigation" href="/isol-manage/login.html">ログアウト</a></li>
	</ul>
</body>
</html>