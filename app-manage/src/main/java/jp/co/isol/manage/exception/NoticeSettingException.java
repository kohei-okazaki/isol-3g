package jp.co.isol.manage.exception;

import jp.co.isol.common.exception.BaseManageException;
import jp.co.isol.common.exception.ErrorCode;

/**
 * 通知設定例外クラス<br>
 *
 */
public class NoticeSettingException extends BaseManageException {

	/**
	 * コンストラクタ<br>
	 * @param errorCode
	 * @param errorMessage
	 */
	public NoticeSettingException(ErrorCode errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}

}
