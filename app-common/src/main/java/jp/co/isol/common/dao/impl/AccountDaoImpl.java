package jp.co.isol.common.dao.impl;

import org.springframework.stereotype.Repository;

import jp.co.isol.common.dao.AccountDao;
import jp.co.isol.common.dto.AccountDto;

/**
 * アカウント情報のDaoクラス
 *
 */
@Repository
public class AccountDaoImpl implements AccountDao {

	/**
	 * 引数で指定されたIDのログインユーザ情報を取得する
	 * @param userId
	 * @return LoginUserEntity
	 */
	@Override
	public AccountDto getAccountByUserId(String userId) {
		AccountDto dto = new AccountDto();
		dto.setUserId(userId);
		dto.setPassword("password");
		return dto;
	}

	/**
	 * ログインユーザ情報を登録する
	 */
	@Override
	public void registAccount() {
		// TODO 登録処理を追加すること
	}

	/**
	 * 引数で指定されたアカウントを更新する
	 * @param form
	 */
	@Override
	public void updateAccount(AccountDto accountDto) {
		// TODO 更新処理を追加すること
	}

	/**
	 * 指定されたアカウントの削除を行う<br>
	 * @param userId
	 */
	@Override
	public void deleteAccount(String userId) {
		// TODO 削除処理を追加すること
	}

}