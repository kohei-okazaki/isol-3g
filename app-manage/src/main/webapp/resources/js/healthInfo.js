function healthInfoCsvDownload() {
	var form = document.createElement('form');
	form.action = '/isol-manage/healthInfo-csvDownload';
	form.method = 'get';
	document.body.appendChild(form);
	form.submit();
}

