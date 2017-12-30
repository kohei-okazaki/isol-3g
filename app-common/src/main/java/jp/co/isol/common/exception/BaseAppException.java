package jp.co.isol.common.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

/**
 * APP内で扱う基底例外クラス<br>
 *
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseAppException extends Exception {

	/** エラーコード */
	protected ErrorCodeDefine errorCode;
	/** エラーメッセージ */
	protected String errorMessage;

}
