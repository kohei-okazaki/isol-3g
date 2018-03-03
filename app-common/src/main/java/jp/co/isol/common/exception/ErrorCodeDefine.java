package jp.co.isol.common.exception;

/**
 * エラーコードの定義<br>
 * API, MVCでのエラーコードをそれぞれ定義する<br>
 */
public enum ErrorCodeDefine {

	/** 必須エラー */
	REQUIRE("REQUIRE", "必須エラーです"),
	/** 属性エラー*/
	TYPE("TYPE", "属性エラーです"),
	/** 桁数エラー */
	LENGTH("LENGTH", "桁数エラーです"),

	/** アカウント不正エラー */
	ACCOUNT_ILLEGAL("ACCOUNT_ILLEGAL"," アカウントが存在しません");

	/** エラーコード */
	private String errorCode;
	/** エラーメッセージ */
	private String errorMessage;

	/**
	 * コンストラクタ<br>
	 * @param errorCode
	 * @param errorMessage
	 */
	private ErrorCodeDefine(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * エラーコードを返す<br>
	 * @return
	 */
	public String getErrorCode() {
		return this.errorCode;
	}

	/**
	 * エラーメッセージを返す<br>
	 * @return
	 */
	public String getErrorMessage() {
		return this.errorMessage;
	}

}
