package jp.co.isol.manage.exception;

import jp.co.isol.common.exception.BaseMvcException;
import jp.co.isol.common.exception.ErrorCodeDefine;

/**
 * 健康情報Exceptionクラス<br>
 *
 */
public class HealthInfoException extends BaseMvcException {

	/**
	 * コンストラクタ<br>
	 * @param errorCode
	 * @param errorMessage
	 */
	public HealthInfoException(ErrorCodeDefine errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}

}