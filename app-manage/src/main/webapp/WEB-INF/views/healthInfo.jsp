<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="manage" uri="/WEB-INF/tag.tld"%>

<html>

<head>
<meta charset="UTF-8">
<title>健康アプリ_健康情報画面</title>
<link rel="icon" type="image/png" href="resources/image/people.png">
<link rel="stylesheet" type="text/css" href="resources/css/layout.css">
<link rel="stylesheet" type="text/css" href="resources/css/common/headericon.css">
<link rel="stylesheet" type="text/css" href="resources/css/menuicon.css">
<link rel="stylesheet" type="text/css" href="resources/css/navigation.css">
<link rel="stylesheet" type="text/css" href="resources/css/healthInfo.css">
<link rel="stylesheet" type="text/css" href="resources/css/input.css">
<link rel="stylesheet" type="text/css" href="resources/css/table.css">
<script type="text/javascript" src="resources/js/common/common.js"></script>
<script type="text/javascript" src="resources/js/healthInfo.js"></script>
</head>

<body class="main">

	<c:if test="${page == 0}">
		<h1>
			<img class="headericon" alt="入力" src="resources/image/icon_input.jpg">
			<c:out value="健康情報入力画面" />
		</h1>
	</c:if>
	<c:if test="${page == 1}">
		<h1 class="title">
			<img class="headericon" alt="確認" src="resources/image/icon_confirm.png">
			<c:out value="健康情報入力確認画面" />
		</h1>
	</c:if>
	<c:if test="${page == 2}">
		<h1 class="title">
			<img class="headericon" alt="確認" src="resources/image/icon_confirm.png">
			<c:out value="健康情報入力完了画面" />
		</h1>
	</c:if>

	<hr>
	<jsp:include page="/WEB-INF/views/common/navigation.jsp" />

	<!-- 入力画面 -->
	<c:if test="${page == 0}">
	<div align="center">
		<p>身長と体重を入力して下さい</p>
	</div>
	<br>
	<div align="center">
		<form action="/isol-manage/healthInfo-confirm.html" method="post">
			<c:out value="身長：" />
			<input type="text" name="height" size="6" required>
			<c:out value="cm" />
			<p class="attention"><c:out value="※半角数字で入力してください" /></p>
			<br><br>
			<c:out value="体重：" />
			<input type="text" name="weight" size="6" required>
			<c:out value="kg" />
			<p class="attention"><c:out value="※半角数字で入力してください" /></p>
			<br>
			<br>
			<table>
				<tr>
					<td><input type="submit" value="確認"></td>
					<td><c:out value="　　" /></td>
					<td><input type="reset" value="リセット"></td>
				</tr>
			</table>
		</form>
	</div>
	</c:if>

	<!-- 確認画面 -->
	<c:if test="${page == 1}">
	<br>
	<div align="center">
		<form action="/isol-manage/healthInfo-complete.html" method="post">
			<c:out value="身長：" />
			<input type="text" name="height" value="${form.height}" size="6" disabled="disabled">
			<input type="hidden" name="height" value="${form.height}" />
			<c:out value="cm" />
			<br><br>
			<c:out value="体重：" />
			<input type="text" name="weight" value="${form.weight}" size="6" disabled="disabled">
			<input type="hidden" name="weight" value="${form.weight}" />
			<c:out value="kg" />
			<br><br>
			<table>
				<tr>
					<td><input type="submit" value="確定"></td>
					<td><c:out value="　　" /></td>
					<td><input type="button" value="戻る" onclick="history.back()"></td>
				</tr>
			</table>
		</form>
	</div>
	</c:if>

	<!-- 完了画面 -->
	<c:if test="${page == 2}">
	<div align="center">
		<br>
		<c:out value="今のあなたの身長(" />
		<manage:centiMeterHeight height="${healthInfo.height}"/>
		<c:out value=")の" />
		<br>
		<c:out value="標準体重は" />
		<manage:weight weight="${healthInfo.standardWeight}" />
		<c:out value="です" />

		<c:if test="${isFirstReg == false}">
			<br><br>
			<c:out value="前回より" />
			<manage:weight weight="${diffWeight}" />
			<c:out value="${resultMessage}" />
			<br>

			<manage:weight weight="${beforeWeight}" />
			<c:out value="→" />
			<manage:weight weight="${healthInfo.weight}" />
		</c:if>

		<br><br><br>
		<table class="custom" border="1">
			<tr class="header">
				<th align="center"><c:out value="身長" /></th>
				<th align="center"><c:out value="体重" /></th>
				<th align="center"><c:out value="標準体重" /></th>
				<th align="center"><c:out value="BMI" /></th>
			</tr>
			<tr class="data">
				<td align="center"><manage:centiMeterHeight height="${healthInfo.height}" /></td>
				<td align="center"><manage:weight weight="${healthInfo.weight}" /></td>
				<td align="center"><manage:weight weight="${healthInfo.standardWeight}" /></td>
				<td align="center"><c:out value="${healthInfo.bmi}" /></td>
			</tr>
		</table>
		<br><br>


		<table>
			<tr>
				<td align="center">
				<!-- 通知  -->
				<form action="/isol-manage/notice.html" method="post">
					<input type="hidden" name="height" value="${healthInfo.height}">
					<input type="hidden" name="weight" value="${healthInfo.weight}">
					<input type="hidden" name="standardWeight" value="${healthInfo.standardWeight}">
					<input type="hidden" name="bmi" value="${healthInfo.bmi}">
					<div>
						<input class="menuicon" type="image" src="resources/image/icon_mail.png">
					</div>
				</form>
				</td>
				<td>　　</td>
				<td align="center">
				<!-- Excel出力 -->
				<form action="/isol-manage/healthInfo-excelDownload.html" method="get">
					<input type="hidden" name="height" value="${healthInfo.height}">
					<input type="hidden" name="weight" value="${healthInfo.weight}">
					<input type="hidden" name="standardWeight" value="${healthInfo.standardWeight}">
					<input type="hidden" name="bmi" value="${healthInfo.bmi}">
					<div>
						<input class="menuicon" type="image" src="resources/image/icon_xlsx.png">
					</div>
				</form>
				</td>
				<td>　　</td>
				<td align="center">
				<!-- CSV出力 -->
				<div>
					<input class="menuicon" type="image" src="resources/image/icon_csv.png" onclick="healthInfoCsvDownload()">
				</div>
				</td>
				<td>　　</td>
				<td align="center">
				<!-- メニュー画面へ -->
				<div>
					<input class="menuicon" type="image" src="resources/image/icon_menu.jpg" onclick="toMenu()">
				</div>
				</td>
			</tr>
		</table>

	</div>
	</c:if>

	<br><br>

	<hr>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

</body>
</html>
