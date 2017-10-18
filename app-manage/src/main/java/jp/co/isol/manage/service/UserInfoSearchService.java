package jp.co.isol.manage.service;

import java.util.List;

import jp.co.isol.manage.dto.UserInfoDto;

/**
 * @author kou1210hei<br>
 * ユーザ情報検索インターフェイス
 *
 */
public interface UserInfoSearchService {

	/**
	 * 全ユーザ情報を取得する
	 * @return 全ユーザ情報
	 */
	public List<UserInfoDto> findUserAllData();

	/**
	 * 指定されたIDからユーザ情報を取得する
	 * @param id
	 * @return ログインユーザ情報
	 */
	public UserInfoDto findUserInfoEntity(String id);
}
