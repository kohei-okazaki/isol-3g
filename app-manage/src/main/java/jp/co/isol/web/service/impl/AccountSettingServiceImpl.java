package jp.co.isol.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.common.dao.AccountDao;
import jp.co.isol.common.dao.MailInfoDao;
import jp.co.isol.common.entity.Account;
import jp.co.isol.common.entity.MailInfo;
import jp.co.isol.web.form.AccountSettingForm;
import jp.co.isol.web.service.AccountSettingService;

/**
 * アカウント設定サービス実装クラス<br>
 *
 */
@Service
public class AccountSettingServiceImpl implements AccountSettingService {

	/** アカウント情報Dao */
	@Autowired
	private AccountDao accountDao;
	/** メール情報Dao */
	@Autowired
	private MailInfoDao mailInfoDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Account account, MailInfo mailInfo) {

		// アカウント情報を更新する
		updateAccount(account);

		// メール情報を更新する
		updateMailInfo(mailInfo);
	}

	/**
	 * {@inheritDoc}
	 */
	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}

	/**
	 * {@inheritDoc}
	 */
	private void updateMailInfo(MailInfo mailInfo) {
		mailInfoDao.updateMailInfo(mailInfo);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAccount(AccountSettingForm form) {
		accountDao.deleteAccount(form.getUserId());
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Account mergeAccount(Account account, AccountSettingForm form) {

		account.setUserId(form.getUserId());
		account.setPassword(form.getPassword());
		account.setFileEnclosureCharFlag(form.getFileEnclosureCharFlag());
		account.setDeleteFlag(form.getDeleteFlag());
		account.setRemarks(form.getRemarks());

		return account;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MailInfo convertMailInfo(AccountSettingForm form) {

		MailInfo mailInfo = new MailInfo();
		mailInfo.setUserId(form.getUserId());
		mailInfo.setMailAddress(form.getMailAddress());
		mailInfo.setMailPassword(form.getMailPassword());

		return mailInfo;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MailInfo mergeMailInfo(MailInfo mailInfo, AccountSettingForm form) {

		mailInfo.setUserId(form.getUserId());
		mailInfo.setMailAddress(form.getMailAddress());
		mailInfo.setMailPassword(form.getMailPassword());

		return mailInfo;
	}

}
