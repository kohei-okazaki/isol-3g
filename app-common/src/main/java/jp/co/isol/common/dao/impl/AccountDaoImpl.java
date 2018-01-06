package jp.co.isol.common.dao.impl;

import org.springframework.dao.DuplicateKeyException;

import jp.co.isol.common.dao.AccountDao;
import jp.co.isol.common.dto.AccountDto;

/**
 * アカウント情報のDaoクラス
 *
 */
public class AccountDaoImpl implements AccountDao {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AccountDto getAccountByUserId(String userId) {
		AccountDto dto = new AccountDto();
		dto.setUserId(userId);
		dto.setPassword("password");
		dto.setInvalidFlag("0");
		return dto;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void registAccount() throws DuplicateKeyException {
		// TODO 登録処理を追加すること
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateAccount(AccountDto accountDto) {
		// TODO 更新処理を追加すること
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAccount(String userId) {
		// TODO 削除処理を追加すること
	}

}
