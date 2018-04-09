package jp.co.isol.web.service;

import jp.co.isol.common.entity.Account;

/**
 * アカウント情報認証サービス実装クラス<br>
 *
 */
@FunctionalInterface
public interface AccountAuthService {

	/**
	 * アカウントチェックを行う<br>
	 * 不正なアカウントの場合true, 正常なアカウントの場合false<br>
	 * @param accountFromSession
	 * @param accountFromDao
	 * @return
	 */
	public boolean invalidAccount(Account accountFromSession, Account accountFromDao);

}
