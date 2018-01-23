package jp.co.isol.manage.form;

import java.io.Serializable;

import jp.co.isol.common.web.mvc.BaseForm;

/**
 * ログインフォームクラス
 *
 */
public class LoginForm extends BaseForm implements Serializable {

	/** ユーザID */
	private String userId;
	/** パスワード */
	private String password;

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
