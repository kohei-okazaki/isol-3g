package jp.co.isol.manage.service;

import jp.co.isol.manage.form.AccountCreateForm;

/**
 * アカウント作成サービスインターフェース
 *
 */
public interface AccountCreateService {

	/**
	 * アカウントを作成する
	 * @param form
	 */
	public void create(AccountCreateForm form);
}
