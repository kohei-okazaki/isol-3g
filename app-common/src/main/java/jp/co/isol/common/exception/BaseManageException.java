package jp.co.isol.common.exception;

/**
 * 管理画面で共通で継承する例外クラス<br>
 *
 */
public abstract class BaseManageException extends BaseAppException {

	/**
	 * コンストラクタ<br>
	 */
	public BaseManageException() {
		super();
	}

	/**
	 * 例外コンストラクタ<br>
	 * @param errorCode エラーコード
	 * @param errorMessage エラーメッセージ
	 */
	protected BaseManageException(ErrorCodeDefine errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}

}
