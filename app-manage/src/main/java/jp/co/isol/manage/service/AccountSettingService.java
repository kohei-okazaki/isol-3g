package jp.co.isol.manage.service;

import jp.co.isol.manage.form.AccountSettingForm;

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


}
