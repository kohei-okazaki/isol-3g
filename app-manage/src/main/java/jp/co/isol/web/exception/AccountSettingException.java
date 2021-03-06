package jp.co.isol.web.exception;

import jp.co.isol.common.exception.BaseManageException;
import jp.co.isol.common.exception.ErrorCode;

/**
 * アカウント設定例外クラス<br>
 *
 */
public class AccountSettingException extends BaseManageException {

	/**
	 * コンストラクタ<br>
	 */
	public AccountSettingException() {
		super();
	}

	/**
	 * コンストラクタ<br>
	 * @param errorCode
	 * @param errorMessage
	 */
	public AccountSettingException(ErrorCode errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}

}
