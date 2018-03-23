package jp.co.isol.manage.exception;

import jp.co.isol.common.exception.BaseManageException;
import jp.co.isol.common.exception.ErrorCode;

/**
 * 健康情報Exceptionクラス<br>
 *
 */
public class HealthInfoException extends BaseManageException {

	/**
	 * コンストラクタ<br>
	 * @param errorCode
	 * @param errorMessage
	 */
	public HealthInfoException(ErrorCode errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}

}
