package jp.co.isol.manage.exception;

import jp.co.isol.common.exception.BaseMvcException;
import jp.co.isol.common.exception.ErrorCodeDefine;

/**
 * 通知設定例外クラス<br>
 *
 */
public class NoticeSettingException extends BaseMvcException {

	/**
	 * コンストラクタ<br>
	 * @param errorCode
	 * @param errorMessage
	 */
	protected NoticeSettingException(ErrorCodeDefine errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}

}
