package jp.co.isol.manage.service;

import jp.co.isol.common.entity.Account;

/**
 * アカウント検索サービスインターフェース<br>
 *
 */
public interface AccountSearchService {

	/**
	 * ユーザIDからアカウント情報を取得する
	 * @param userId
	 * @return アカウント情報
	 */
	public Account findAccountByUserId(String userId);
}
