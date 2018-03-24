package jp.co.isol.common.exception;

/**
 * 実行環境での基底例外クラス<br>
 *
 */
public abstract class BaseAppRuntimeException extends RuntimeException {

	/** エラーコード */
	private ErrorCode errorCode;
	/** エラーメッセージ */
	protected String errorMessage;

	/**
	 * 引数ありのコンストラクタ<br>
	 * @param errorMessage
	 */
	public BaseAppRuntimeException(ErrorCode errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * errorCodeを返す
	 * @return errorCode
	 */
	public ErrorCode getErrorCode() {
		return errorCode;
	}

	/**
	 * errorMessageを返す
	 * @return errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}


}
