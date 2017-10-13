package jp.co.isol.manage.service;

import jp.co.isol.manage.dto.LoginUserDto;

public interface LoginUserSearchService {

	/**
	 * IDからログイン情報を取得する
	 * @param id
	 * @return ログイン情報
	 */
	public LoginUserDto getLoginUserEntity(String id);
}
