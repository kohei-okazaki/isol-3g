package jp.co.isol.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.manage.dao.AccountDao;
import jp.co.isol.manage.dto.AccountDto;
import jp.co.isol.manage.service.AccountSearchService;

@Service
public class AccountSearchServiceImpl implements AccountSearchService {

	@Autowired
	private AccountDao accountDao;

	/**
	 * ユーザIDからログイン情報を取得する
	 * @param userId
	 * @return ログイン情報
	 */
	@Override
	public AccountDto findAccountByUserId(String userId) {
		return accountDao.getLoginUserInfoByUserId(userId);
	}

}
