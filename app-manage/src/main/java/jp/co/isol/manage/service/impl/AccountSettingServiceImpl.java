package jp.co.isol.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.manage.dao.AccountDao;
import jp.co.isol.manage.form.AccountSettingForm;
import jp.co.isol.manage.form.LoginUserForm;
import jp.co.isol.manage.service.AccountSettingService;

@Service
public class AccountSettingServiceImpl implements AccountSettingService {

	@Autowired
	private AccountDao accountDao;

	/**
	 * IDで指定されたアカウントのパスワードを変更する<br>
	 * @param form
	 */
	@Override
	public void changePassword(LoginUserForm form) {
		accountDao.updateLoginUserInfo(form);
	}

	/**
	 * 指定されたアカウントの削除をする<br>
	 * @param form
	 */
	@Override
	public void deleteAccount(AccountSettingForm form) {
		accountDao.deleteLoginUserInfo(form.getUserId());
	}

}
