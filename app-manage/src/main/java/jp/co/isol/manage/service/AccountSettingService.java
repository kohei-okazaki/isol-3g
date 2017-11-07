package jp.co.isol.manage.service;

import jp.co.isol.manage.form.AccountSettingForm;

/**
 * アカウント設定サービスIF
 *
 */
public interface AccountSettingService {

	/**
	 * IDで指定されたアカウントのパスワードを変更する<br>
	 * @param form
	 */
	public void changePassword(AccountSettingForm form);

	/**
	 * 指定されたアカウントの削除をする<br>
	 * @param form
	 */
	public void deleteAccount(AccountSettingForm form);

	/**
	 * 入力されたアカウント設定フォーム情報が不正かどうか判定する<br>
	 * @param form
	 * @return 判定結果
	 */
	public boolean invalidForm(AccountSettingForm form);


}
