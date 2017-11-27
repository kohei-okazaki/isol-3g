package jp.co.isol.manage.service;

import jp.co.isol.manage.form.AccountSettingForm;

/**
 * アカウント設定サービスIF
 *
 */
public interface AccountSettingService {

	/**
	 * アカウント設定formで指定されたアカウント情報に更新する<br>
	 * @param form
	 */
	public void changePassword(AccountSettingForm form);

	/**
	 * 指定されたアカウント情報の削除をする<br>
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
