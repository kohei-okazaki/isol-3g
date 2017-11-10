package jp.co.isol.api.exception;

/**
 * 健康情報のExceptionクラス<br>
 *
 */
public class HealthInfoException extends BaseApiException {

	public HealthInfoException(String errorEmessage) {
		this.errorMessage = errorEmessage;
	}
}
