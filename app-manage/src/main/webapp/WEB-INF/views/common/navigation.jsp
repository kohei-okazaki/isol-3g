<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/common/bmiModal.css">
<link rel="stylesheet" type="text/css" href="resources/css/common/standardWeightModal.css">
<script type="text/javascript" src="resources/js/common/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/common/bmiModal.js"></script>
<script type="text/javascript" src="resources/js/common/standardWeightModal.js"></script>
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
		<li><a class="navigation" href="#">その他</a>
			<ul>
				<li><a class="navigation" href="#">健康情報</a>
					<ul>
						<li><a id="bmi-modal-open" class="bmi-button-link">BMI</a></li>
						<li><a id="standardWeight-modal-open" class="standardWeight-button-link">標準体重</a></li>
					</ul>
				</li>
			</ul>
		</li>
		<li><a class="navigation" href="/isol-manage/login.html">ログアウト</a></li>
	</ul>


<!-- ここからBMIモーダルウィンドウ -->
<div id="bmi-modal-content">
	BMIとは。。。
	<p><a id="bmi-modal-close" class="bmi-button-link">閉じる</a></p>
	<!-- モーダルウィンドウのコンテンツ終了 -->
</div>
<!-- ここまでBMIモーダルウィンドウ -->

<!-- ここから標準体重モーダルウィンドウ -->
<div id="standardWeight-modal-content">
	標準体重とは。。。
	<p><a id="standardWeight-modal-close" class="standardWeight-button-link">閉じる</a></p>
	<!-- モーダルウィンドウのコンテンツ終了 -->
</div>
<!-- ここから標準体重モーダルウィンドウ -->



</body>
</html>