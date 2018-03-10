package jp.co.isol.manage.exception;

import jp.co.isol.common.exception.BaseManageException;
import jp.co.isol.common.exception.ErrorCodeDefine;

/**
 * ログイン画面のExceptionクラス<br>
 *
 */
public class LoginException extends BaseManageException {

	/**
	 * コンストラクタ<br>
	 * @param errorCode
	 * @param errorMessage
	 */
	public LoginException(ErrorCodeDefine errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}
}
