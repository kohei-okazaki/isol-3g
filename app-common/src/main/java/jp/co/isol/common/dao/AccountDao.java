package jp.co.isol.common.dao;

import jp.co.isol.common.dto.AccountDto;

/**
 * アカウント情報のDaoインターフェイス
 *
 */
public interface AccountDao {

	/**
	 * 引数で指定されたユーザIDのアカウント情報を取得する
	 * @param userId
	 * @return AccountDto
	 */
	public AccountDto getAccountByUserId(String userId);

	/**
	 * アカウント情報を登録する
	 */
	public void registAccount();

	/**
	 * 引数で指定されたアカウント情報を更新する
	 * @param accountDto
	 */
	public void updateAccount(AccountDto accountDto);

	/**
	 * 指定されたアカウント情報の削除を行う<br>
	 * @param userId
	 */
	public void deleteAccount(String userId);

}
