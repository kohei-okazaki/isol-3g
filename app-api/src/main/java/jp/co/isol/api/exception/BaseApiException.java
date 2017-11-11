package jp.co.isol.api.exception;

/**
 * APIで共通に扱う例外クラス<br>
 *
 */
public abstract class BaseApiException extends Exception {

	/** エラーメッセージ */
	protected String errorMessage;

}
