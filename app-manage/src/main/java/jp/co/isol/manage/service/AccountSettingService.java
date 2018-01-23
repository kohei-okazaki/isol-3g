package jp.co.isol.manage.service;

import jp.co.isol.manage.form.AccountSettingForm;

/**
 * アカウント設定サービスインターフェース<br>
 *
 */
public interface AccountSettingService {

	/**
	 * 更新処理を行う<br>
	 * @param form
	 */
	public void update(AccountSettingForm form);

	/**
	 * 指定されたアカウント情報の削除をする<br>
	 * @param form
	 */
	public void deleteAccount(AccountSettingForm form);

	/**
	 * 入力されたアカウント設定フォーム情報が不正かどうか判定する<br>
	 * 不正な値の場合true, そうでない場合falseを返す<br>
	 * @param form
	 * @return 判定結果
	 */
	public boolean invalidForm(AccountSettingForm form);


}
