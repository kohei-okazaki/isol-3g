package jp.co.isol.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.common.dao.AccountDao;
import jp.co.isol.common.entity.Account;
import jp.co.isol.manage.service.AccountSearchService;

/**
 * アカウント検索サービス実装クラス<br>
 *
 */
@Service
public class AccountSearchServiceImpl implements AccountSearchService {

	/** アカウント情報Dao */
	@Autowired
	private AccountDao accountDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Account findAccountByUserId(String userId) {
		return this.accountDao.getAccountByUserId(userId);
	}

}
