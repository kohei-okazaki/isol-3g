function finish() {
	var finishMessage = document.write('出力しました');
	alert(finishMessage);
}

function referenceExcelDownload() {
	var form = document.createElement('form');
	form.action = '/isol-manage/result-reference-excelDownload.html';
	form.method = 'get';
	document.body.appendChild(form);
	form.submit();
}

function accountCreate() {
	var form = document.createElement('form');
	form.action = '/isol-manage/account-create-input.html';
	form.method = 'get';
	document.body.appendChild(form);
	form.submit();
}

