package jp.co.isol.web.form;

import java.io.Serializable;

import jp.co.isol.common.web.manage.BaseForm;

/**
 * ログインフォームクラス
 *
 */
public class LoginForm implements BaseForm, Serializable {

	/** ユーザID */
	private String userId;
	/** パスワード */
	private String password;

	/**
	 * デフォルトコンストラクタ<br>
	 */
	public LoginForm() {

	}

	/**
	 * userIdを返す
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * userIdを設定する
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * passwordを返す
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * passwordを設定する
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
