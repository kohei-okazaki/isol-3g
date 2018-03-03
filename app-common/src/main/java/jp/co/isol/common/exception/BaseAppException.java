package jp.co.isol.common.exception;

/**
 * APP内で扱う基底例外クラス<br>
 *
 */
public abstract class BaseAppException extends Exception {

	/** エラーコード */
	protected ErrorCodeDefine errorCode;
	/** エラーメッセージ */
	protected String errorMessage;

	/**
	 * 例外コンストラクタ<br>
	 */
	public BaseAppException() {

	}

	/**
	 * 例外コンストラクタ<br>
	 * @param errorCode
	 * @param errorMessage
	 */
	public BaseAppException(ErrorCodeDefine errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * ErrorCodeDefineを返す<br>
	 * @return errorCode
	 */
	public ErrorCodeDefine getErrorCodeDefine() {
		return errorCode;
	}

}
