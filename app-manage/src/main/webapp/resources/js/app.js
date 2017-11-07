function finish() {
	var finishMessage = dosument.write("出力しました");
	alert(finishMessage);
}

function referenceExcelDownload() {
	var form = document.createElement('form');
	form.action = '/isol-manage/result-reference-download.html';
	form.method = 'get';
	document.body.appendChild(form);
	form.submit();
}