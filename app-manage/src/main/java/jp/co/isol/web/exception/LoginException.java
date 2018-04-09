package jp.co.isol.web.exception;

import jp.co.isol.common.exception.BaseManageException;
import jp.co.isol.common.exception.ErrorCode;

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
	public LoginException(ErrorCode errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}
}
