package jp.co.isol.manage.exception;

import jp.co.isol.common.exception.BaseMvcException;

/**
 * ログイン画面のExceptionクラス<br>
 *
 */
public class LoginException extends BaseMvcException {

	/**
	 * コンストラクタ<br>
	 * @param errorMessage
	 */
	public LoginException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
