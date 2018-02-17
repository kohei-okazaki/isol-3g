package jp.co.isol.manage.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.common.dao.AccountDao;
import jp.co.isol.common.entity.Account;
import jp.co.isol.common.manager.CodeManager;
import jp.co.isol.common.manager.MainKey;
import jp.co.isol.common.manager.SubKey;
import jp.co.isol.common.util.DateUtil;
import jp.co.isol.common.util.StringUtil;
import jp.co.isol.manage.form.AccountCreateForm;
import jp.co.isol.manage.service.AccountCreateService;

/**
 * アカウント作成サービス実装クラス
 *
 */
@Service
public class AccountCreateServiceImpl implements AccountCreateService {

	@Autowired
	private AccountDao accountDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void create(Account account) {
		accountDao.registAccount(account);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Account toAccount(AccountCreateForm form) {

		Account account = new Account();
		account.setUserId(form.getUserId());
		account.setPassword(form.getPassword());
		account.setDeleteFlag(CodeManager.getInstance().getValue(MainKey.FLAG, SubKey.FALSE));
		account.setRemarks(form.getRemarks());
		account.setFileEnclosureCharFlag(CodeManager.getInstance().getValue(MainKey.FLAG, SubKey.FALSE));
		account.setPasswordExpire(DateUtil.addMonth(new Date(), 6));

		return account;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean invalidUserId(AccountCreateForm form) {

		// 指定したアカウント情報を検索
		Account account = accountDao.getAccountByUserId(form.getUserId());

		// ユーザIDが存在する場合true, 存在しない場合false
		return !StringUtil.isEmpty(account.getUserId());
	}

}
