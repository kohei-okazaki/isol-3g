package jp.co.isol.manage.exception;

import jp.co.isol.common.exception.BaseManageException;
import jp.co.isol.common.exception.ErrorCodeDefine;

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
	public AccountSettingException(ErrorCodeDefine errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}

}
