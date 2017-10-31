package jp.co.isol.manage.service;

import jp.co.isol.manage.dto.AccountDto;

public interface AccountSearchService {

	/**
	 * ユーザIDからログイン情報を取得する
	 * @param userId
	 * @return ログイン情報
	 */
	public AccountDto findAccountByUserId(String userId);
}
