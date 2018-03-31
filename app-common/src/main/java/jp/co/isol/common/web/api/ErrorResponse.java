package jp.co.isol.common.web.api;

import jp.co.isol.common.exception.BaseApiException;
import jp.co.isol.common.exception.ErrorCode;

/**
 * エラーレスポンスクラス<br>
 *
 */
public class ErrorResponse extends BaseResponse {

	/** エラーコード*/
	private ErrorCode errorCode;
	/** エラーメッセージ */
	private String errorMessage;

	/**
	 * コンストラクタ<br>
	 * @param e
	 */
	public ErrorResponse(BaseApiException e) {
		setErrorResult();
		this.errorCode = e.getErrorCode();
		this.errorMessage = e.getErrorMessage();
	}
	/**
	 * errorCodeを返す
	 * @return errorCode
	 */
	public ErrorCode getErrorCode() {
		return errorCode;
	}
	/**
	 * errorCodeを設定する
	 * @param errorCode
	 */
	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * errorMessageを返す
	 * @return errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * errorMessageを設定する
	 * @param errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
