package jp.co.isol.manage.service;

import jp.co.isol.manage.dto.AccountDto;

public interface AccountSearchService {

	/**
	 * IDからログイン情報を取得する
	 * @param id
	 * @return ログイン情報
	 */
	public AccountDto findAccountByUserId(String userId);
}
