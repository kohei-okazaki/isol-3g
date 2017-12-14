package jp.co.isol.common.exception;

/**
 * 実行環境での基底例外クラス<br>
 *
 */
public class BaseAppRuntimeException extends RuntimeException {

	/** エラーメッセージ */
	protected String errorMessage;

	/**
	 * 引数ありのコンストラクタ<br>
	 * @param errorMessage
	 */
	public BaseAppRuntimeException(String errorMessage) {
		super(errorMessage);
	}

}
