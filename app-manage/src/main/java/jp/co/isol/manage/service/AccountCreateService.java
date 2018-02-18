package jp.co.isol.manage.service;

import jp.co.isol.common.entity.Account;
import jp.co.isol.manage.form.AccountCreateForm;

/**
 * アカウント作成サービスインターフェース
 *
 */
public interface AccountCreateService {

	/**
	 * アカウントを作成する<br>
	 * @param account
	 */
	public void create(Account account);

	/**
	 * アカウントEntityに変換する<br>
	 * @param form
	 * @return
	 */
	public Account toAccount(AccountCreateForm form);

	/**
	 * 指定したアカウント情報が有効かどうか判定する<br>
	 * 作成できないアカウント情報の場合true, それ以外の場合false<br>
	 * @return
	 */
	public boolean invalidUserId(AccountCreateForm form);
}
