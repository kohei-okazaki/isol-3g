package jp.co.isol.manage.service.impl;

import org.springframework.stereotype.Service;

import jp.co.isol.manage.dao.LoginUserDao;
import jp.co.isol.manage.form.LoginUserForm;
import jp.co.isol.manage.service.AccountSettingService;

@Service
public class AccountSettingServiceImpl implements AccountSettingService {

	private LoginUserDao loginUserDao;

	/**
	 * IDで指定されたアカウントのパスワードを変更する<br>
	 * @param form
	 */
	@Override
	public void changePassword(LoginUserForm form) {
		loginUserDao.updateLoginUserInfo(form);
	}

}
