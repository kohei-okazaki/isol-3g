function finish() {
	var finishMessage = document.write('出力しました');
	alert(finishMessage);
}

function toMenu() {
	var form = document.createElement('form');
	form.action = '/isol-manage/menu.html';
	form.method = 'get';
	document.body.appendChild(form);
	form.submit();
}