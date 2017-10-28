package jp.co.isol.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.manage.dao.LoginUserDao;
import jp.co.isol.manage.dto.AccountDto;
import jp.co.isol.manage.service.AccountSearchService;

@Service
public class AccountSearchServiceImpl implements AccountSearchService {

	@Autowired
	private LoginUserDao loginUserDao;

	/**
	 * IDからログイン情報を取得する
	 * @param id
	 * @return ログイン情報
	 */
	@Override
	public AccountDto findAccountByUserId(String userId) {
		return loginUserDao.getLoginUserInfoByUserId(userId);
	}

}
