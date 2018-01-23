package jp.co.isol.manage.exception;

import jp.co.isol.common.exception.BaseMvcException;
import jp.co.isol.common.exception.ErrorCodeDefine;

/**
 * アカウント作成例外クラス
 *
 */
public class AccountCreateException extends BaseMvcException {

	/**
	 * コンストラクタ<br>
	 */
	public AccountCreateException() {
		super();
	}

	/**
	 * コンストラクタ<br>
	 * @param errorCode
	 * @param errorMessage
	 */
	public AccountCreateException(ErrorCodeDefine errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}
}
