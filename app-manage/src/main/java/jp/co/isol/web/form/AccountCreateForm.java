package jp.co.isol.web.form;

import java.io.Serializable;

import jp.co.isol.common.web.manage.BaseForm;

/**
 * アカウント作成Form
 *
 */
public class AccountCreateForm implements BaseForm, Serializable {

	/** ユーザID */
	private String userId;
	/** パスワード */
	private String password;
	/** 確認用パスワード */
	private String confirmPassword;
	/** 備考 */
	private String remarks;

	/**
	 * デフォルトコンストラクタ<br>
	 */
	public AccountCreateForm() {

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
	/**
	 * confirmPasswordを返す
	 * @return confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}
	/**
	 * confirmPasswordを設定する
	 * @param confirmPassword
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	/**
	 * remarksを返す
	 * @return remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * remarksを設定する
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
