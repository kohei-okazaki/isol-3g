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
	<jsp:include page="/WEB-INF/views/common/navigation.jsp" />

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
					<th class="header" width="130px">
						<c:out value="削除" />
					</th>
					<td class="data" width="250px">
						<div class="radio">
							<input type="radio" name="deleteFlag" id="deleteFlagTrue" value="1" checked="checked">
							<label for="deleteFlagTrue">する</label>
							<input type="radio" name="deleteFlag" id="deleteFlagFalse" value="0">
							<label for="deleteFlagFalse" class="switch-off">しない</label>
						</div>
					</td>
				</tr>
				<tr>
					<th class="header">
						<c:out value="ユーザID" />
					</th>
					<td class="data">
						<c:out value="${account.userId}" />
						<input type="hidden" name="userId" value="${account.userId}" />
					</td>
				</tr>
				<tr>
					<th class="header">
						<c:out value="パスワード" />
					</th>
					<td class="data">
						<input type="text" name="password" value="${account.password}" required="required" />
					</td>
				</tr>
				<tr>
					<th class="header" width="130px">
						<c:out value="囲い文字を利用" />
					</th>
					<td class="data" width="250px">
						<div class="radio">
							<input type="radio" name="fileEnclosureCharFlag" id="fileEnclosureCharFlagTrue" value="1" checked="checked">
							<label for="fileEnclosureCharFlagTrue">する</label>
							<input type="radio" name="fileEnclosureCharFlag" id="fileEnclosureCharFlagFalse" value="0">
							<label for="fileEnclosureCharFlagFalse" class="switch-off">しない</label>
						</div>
					</td>
				</tr>
				<tr>
					<th class="header" width="130px">
						<c:out value="メールアドレス" />
					</th>
					<td class="data">
						<input type="email" name="mailAddress" value="${mailInfo.mailAddress}" required="required" />
					</td>
				</tr>
				<tr>
					<th class="header" width="130px">
						<c:out value="メールパスワード" />
					</th>
					<td class="data">
						<input type="text" name="mailPassword" value="${mailInfo.mailPassword}" required="required" />
					</td>
				</tr>
				<tr>
					<th class="header"><c:out value="備 考" /></th>
					<td class="data">
						<textarea rows="10" cols="30" name="remarks" ></textarea>
					</td>
				</tr>
			</table>
			<br><br>
			<table>
				<tr>
					<td>
						<input type="submit" value="確 認" />
					</td>
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
					<th class="header" width="130px">
						<c:out value="削除" />
					</th>
					<td class="data" width="250px">
						<c:if test="${form.deleteFlag == '1'}">する</c:if>
						<c:if test="${form.deleteFlag == '0'}">しない</c:if>
						<input type="hidden" name="deleteFlag" value="${form.deleteFlag}" />
					</td>
				</tr>
				<tr>
					<th class="header">
						<c:out value="ユーザID" />
					</th>
					<td class="data">
						<c:out value="${form.userId}" />
						<input type="hidden" name="userId" value="${form.userId}" />
					</td>
				</tr>
				<tr>
					<th class="header">
						<c:out value="パスワード" />
					</th>
					<td class="data">
						<c:out value="${form.password}" />
						<input type="hidden" name="password" value="${form.password}" />
					</td>
				</tr>
				<tr>
					<th class="header" width="130px">
						<c:out value="囲い文字利用" />
					</th>
					<td class="data" width="250px">
						<c:if test="${form.fileEnclosureCharFlag == '1'}">する</c:if>
						<c:if test="${form.fileEnclosureCharFlag == '0'}">しない</c:if>
						<input type="hidden" name="fileEnclosureCharFlag" value="${form.fileEnclosureCharFlag}" />
					</td>
				</tr>
				<tr>
					<th class="header" width="130px">
						<c:out value="メールアドレス" />
					</th>
					<td class="data">
						<c:out value="${form.mailAddress}" />
						<input type="hidden" name="mailAddress" value="${form.mailAddress}" />
					</td>
				</tr>
				<tr>
					<th class="header" width="130px">
						<c:out value="メールパスワード" />
					</th>
					<td class="data">
						<c:out value="${form.mailPassword}" />
						<input type="hidden" name="mailPassword" value="${form.mailPassword}" />
					</td>
				</tr>
				<tr>
					<th class="header">
						<c:out value="備 考" />
					</th>
					<td class="data">
						<c:out value="${form.remarks}" />
						<input type="hidden" name="remarks" value="${form.remarks}" />
					</td>
				</tr>
			</table>
			<br><br>
			<table>
				<tr>
					<td>
						<input type="submit" value="確 定" />
					</td>
					<td>
						<c:out value="　　" />
					</td>
					<td>
						<input type="button" value="戻 る" onclick="history.back()">
					</td>
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
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

</body>
</html>