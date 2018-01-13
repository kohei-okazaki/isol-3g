package jp.co.isol.common.exception;

/**
 * APIで共通に扱う例外クラス<br>
 *
 */
public abstract class BaseApiException extends BaseAppException {

	/**
	 * コンストラクタ<br>
	 */
	public BaseApiException() {
		super();
	}

	/**
	 * 例外コンストラクタ<br>
	 * @param errorCode エラーコード
	 * @param errorMessage エラーメッセージ
	 */
	protected BaseApiException(ErrorCodeDefine errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}

}
