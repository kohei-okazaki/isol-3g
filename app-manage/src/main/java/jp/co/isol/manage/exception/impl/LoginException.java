package jp.co.isol.manage.exception.impl;

import jp.co.isol.manage.exception.BaseManageException;

/**
 * ログイン画面のExceptionクラス<br>
 *
 */
public class LoginException extends BaseManageException {

	/**
	 * コンストラクタ<br>
	 * @param errorMessage
	 */
	public LoginException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
