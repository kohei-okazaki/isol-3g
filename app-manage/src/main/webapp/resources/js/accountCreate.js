function accountCreate() {
	var form = document.createElement('form');
	form.action = '/isol-manage/account-create-input.html';
	form.method = 'get';
	document.body.appendChild(form);
	form.submit();
}

