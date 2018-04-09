package jp.co.isol.web.service.impl;

import java.util.Objects;

import org.springframework.stereotype.Service;

import jp.co.isol.common.entity.Account;
import jp.co.isol.web.service.AccountAuthService;

/**
 * アカウント情報認証サービス実装クラス<br>
 *
 */
@Service
public class AccountAuthServiceImpl implements AccountAuthService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean invalidAccount(Account accountFromSession, Account accountFromDao) {
		String userIdFromSession = accountFromSession.getUserId();
		String userIdFromDao = accountFromDao.getUserId();
		if (Objects.isNull(userIdFromSession) || Objects.isNull(userIdFromDao) || !userIdFromSession.equals(userIdFromDao)) {
			// 不正なアカウント
			return true;
		}

		String passwordFromSession = accountFromSession.getPassword();
		String passwordFromDao = accountFromDao.getPassword();
		if (Objects.isNull(passwordFromSession) || Objects.isNull(passwordFromDao) || !passwordFromSession.equals(passwordFromDao)) {
			// 不正なアカウント
			return true;
		}
		return false;
	}
}
