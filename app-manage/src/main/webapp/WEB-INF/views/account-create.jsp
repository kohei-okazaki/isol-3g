<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>

<head>
<meta charset="UTF-8">
<title>健康アプリ_アカウント作成画面</title>
<link rel="icon" type="image/png" href="resources/image/people.png">
<link rel="stylesheet" type="text/css" href="resources/css/layout.css">
<script type="text/javascript" src="resources/js/app.js"></script>
</head>

<body class="main">

	<c:if test="${page == 0}">
		<h1>
			<img class="headericon" alt="入力" src="resources/image/icon_input.jpg">
			<c:out value="アカウント作成画面" />
		</h1>
	</c:if>
	<c:if test="${page == 1}">
		<h1 class="title">
			<img class="headericon" alt="確認" src="resources/image/icon_confirm.png">
			<c:out value="アカウント作成確認画面" />
		</h1>
	</c:if>
	<c:if test="${page == 2}">
		<h1 class="title">
			<img class="headericon" alt="確認" src="resources/image/icon_confirm.png">
			<c:out value="アカウント作成完了画面" />
		</h1>
	</c:if>

	<hr>

	<br><br>

	<!-- 入力画面 -->
	<c:if test="${page == 0}">
		<form action="/isol-manage/account-create-confirm.html" method="post">
		<div align="center">

			<c:if test="${errorMessage != null}">
				<c:out value="${errorMessage}" />
			</c:if>
			<table border="1">
				<tr>
					<th class="header" width="130px">
						<c:out value="ユーザID" />
					</th>
					<td class="data" width="250px">
						<input type="text" name="userId" maxlength="16" required="required" />
					</td>
				</tr>
				<tr>
					<th class="header" width="130px">
						<c:out value="パスワード" />
					</th>
					<td class="data" width="250px">
						<input type="text" name="password" maxlength="16" required="required" />
					</td>
				</tr>
				<tr>
					<th class="header">
						<c:out value="確認用 パスワード" />
					</th>
					<td class="data" width="250px">
						<input type="text" name="confirmPassword" maxlength="16" required="required" />
					</td>
				</tr>
				<tr>
					<th class="header">
						<c:out value="備 考" />
					</th>
					<td class="data">
						<textarea rows="10" cols="30" name="remarks" ></textarea>
					</td>
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
		<form action="/isol-manage/account-create-complete.html" method="post">
		<div align="center">
			<table border="1">
				<tr>
					<th class="header" width="130px">
						<c:out value="ユーザID" />
					</th>
					<td class="data" width="250px">
						<input type="text" name="userId" maxlength="16" required="required" value="${form.userId}" readonly="readonly" />
					</td>
				</tr>
				<tr>
					<th class="header" width="130px">
						<c:out value="パスワード" />
					</th>
					<td class="data" width="250px">
						<input type="text" name="password" maxlength="16" required="required" value="${form.password}" readonly="readonly" />
					</td>
				</tr>
				<tr>
					<th class="header">
						<c:out value="確認用 パスワード" />
					</th>
					<td class="data" width="250px">
						<input type="text" name="confirmPassword" maxlength="16" required="required" value="${form.confirmPassword}" readonly="readonly" />
					</td>
				</tr>
				<tr>
					<th class="header">
						<c:out value="備 考" />
					</th>
					<td class="data">
						<textarea rows="10" cols="30" name="remarks" value="${form.remarks}"></textarea>
					</td>
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
						<form action="/isol-manage/login.html" method="get">
							<input type="submit" value="ログイン画面" />
						</form>
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