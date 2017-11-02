package jp.co.isol.manage.service;

import jp.co.isol.manage.dto.AccountDto;

/**
 * @author kou1210hei<br>
 * アカウント検索サービスIF<br>
 *
 */
public interface AccountSearchService {

	/**
	 * ユーザIDからアカウント情報を取得する
	 * @param userId
	 * @return アカウント情報
	 */
	public AccountDto findAccountByUserId(String userId);
}
