package jp.co.isol.api.exception.impl;

import jp.co.isol.api.exception.BaseApiException;

/**
 * 健康情報のExceptionクラス<br>
 *
 */
public class HealthInfoException extends BaseApiException {

	/**
	 * コンストラクタ<br>
	 * @param errorEmessage
	 */
	public HealthInfoException(String errorEmessage) {
		this.errorMessage = errorEmessage;
	}
}
