package jp.co.isol.manage.exception;

import jp.co.isol.common.exception.BaseManageException;
import jp.co.isol.common.exception.ErrorCode;

/**
 * アカウント作成例外クラス
 *
 */
public class AccountCreateException extends BaseManageException {

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
	public AccountCreateException(ErrorCode errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}
}
