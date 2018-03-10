<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="manage" uri="/WEB-INF/tag.tld"%>

<html>

<head>
<meta charset="UTF-8">
<title>健康アプリ_結果照会画面</title>
<link rel="icon" type="image/png" href="resources/image/people.png">
<link rel="stylesheet" type="text/css" href="resources/css/layout.css">
<link rel="stylesheet" type="text/css" href="resources/css/navigation.css">
<link rel="stylesheet" type="text/css" href="resources/css/menuicon.css">
<link rel="stylesheet" type="text/css" href="resources/css/common/headericon.css">
<link rel="stylesheet" type="text/css" href="resources/css/table.css">
<script type="text/javascript" src="resources/js/common.js"></script>
<script type="text/javascript" src="resources/js/reference.js"></script>
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
				<th align="center"><c:out value="身長" /></th>
				<th align="center"><c:out value="体重" /></th>
				<th align="center"><c:out value="標準体重" /></th>
				<th align="center"><c:out value="BMI" /></th>
				<th align="center"><c:out value="登録日時" /></th>
			</tr>
			<c:forEach var="result" items="${resultList}">
				<tr class="data">
					<td align="center"><manage:centiMeterHeight height="${result.height}" /></td>
					<td align="center"><manage:weight weight="${result.weight}" /></td>
					<td align="center"><manage:weight weight="${result.standardWeight}" /></td>
					<td align="center"><c:out value="${result.bmi}" /></td>
					<td align="center"><manage:date date="${result.regDate}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br><br>

	<div align="center">
		<table>
			<tr>
				<td align="center">
					<div>
						<input class="menuicon" type="image" src="resources/image/icon_xlsx.png" onclick="referenceExcelDownload()" >
					</div>
				</td>
				<td>　　</td>
				<td align="center">
					<%-- <form action="/isol-manage/result-reference-csvDownload"> --%>
						<div>
							<input class="menuicon" type="image" src="resources/image/icon_csv.png" onclick="referenceCsvDownload()">
						</div>
					<%-- </form> --%>
				</td>
			</tr>
		</table>
	</div>

	<hr>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

</body>
</html>