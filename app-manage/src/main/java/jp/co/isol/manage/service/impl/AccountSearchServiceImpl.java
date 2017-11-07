package jp.co.isol.manage.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import jp.co.isol.common.dao.AccountDao;
import jp.co.isol.common.dto.AccountDto;
import jp.co.isol.manage.service.AccountSearchService;
import jp.co.isol.manage.web.config.ManageConfig;

/**
 * アカウント検索サービス実装クラス<br>
 *
 */
@Service
public class AccountSearchServiceImpl implements AccountSearchService {

	/**
	 * ユーザIDからアカウント情報を取得する
	 * @param userId
	 * @return アカウント情報
	 */
	@Override
	public AccountDto findAccountByUserId(String userId) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class);
		AccountDao accountDao = context.getBean(AccountDao.class);
		return accountDao.getAccountByUserId(userId);
	}

}
