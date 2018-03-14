function referenceCsvDownload() {
	var form = document.createElement('form');
	form.action = '/isol-manage/result-reference-csvDownload';
	form.method = 'get';
	document.body.appendChild(form);
	form.submit();
}
