package jp.co.isol.api.exception;

import jp.co.isol.common.exception.BaseApiException;
import jp.co.isol.common.exception.ErrorCodeDefine;

/**
 * 健康情報のExceptionクラス<br>
 *
 */
public class HealthInfoException extends BaseApiException {

	/**
	 * {@inheritDoc}
	 */
	public HealthInfoException(ErrorCodeDefine errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}

}
