package jp.co.isol.manage.exception;

import jp.co.isol.common.exception.BaseMvcException;
import jp.co.isol.common.exception.ErrorCodeDefine;

/**
 * ログイン画面のExceptionクラス<br>
 *
 */
public class LoginException extends BaseMvcException {

	/**
	 * コンストラクタ<br>
	 * @param errorMessage
	 */
	public LoginException(ErrorCodeDefine errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}
}
