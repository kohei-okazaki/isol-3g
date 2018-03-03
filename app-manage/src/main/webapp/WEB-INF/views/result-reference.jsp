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
	<jsp:include page="/WEB-INF/views/common/navigation.jsp" />

	<br><br>
	<div align="center">
		<table border="1">
			<tr class="header">
				<th align="center"><c:out value="身長(cm)" /></th>
				<th align="center"><c:out value="体重(kg)" /></th>
				<th align="center"><c:out value="標準体重(kg)" /></th>
				<th align="center"><c:out value="BMI" /></th>
				<th align="center"><c:out value="登録日時" /></th>
			</tr>
			<c:forEach var="result" items="${resultList}">
				<tr class="data">
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

	<div align="center">
		<table>
			<tr>
				<td align="center">
					<form action="/isol-manage/result-reference-excelDownload.html" method="get">
						<div>
							<input class="menuicon" type="image" src="resources/image/icon_xlsx.png">
						</div>
					</form>
				</td>
				<td>　　</td>
				<td align="center">
					<form action="/isol-manage/result-reference-csvDownload">
						<div>
							<input class="menuicon" type="image" src="resources/image/icon_csv.png">
						</div>
					</form>
				</td>
			</tr>
		</table>
	</div>

	<hr>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

</body>
</html>