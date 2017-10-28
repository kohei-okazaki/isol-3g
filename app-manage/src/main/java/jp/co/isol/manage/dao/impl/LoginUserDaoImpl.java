package jp.co.isol.manage.dao.impl;

import org.springframework.stereotype.Repository;

import jp.co.isol.manage.dao.LoginUserDao;
import jp.co.isol.manage.dto.AccountDto;
import jp.co.isol.manage.form.LoginUserForm;

/**
 * @author kou1210hei<br>
 * ログインユーザ情報のDaoクラス
 *
 */
@Repository
public class LoginUserDaoImpl implements LoginUserDao {

	@Override
	public AccountDto getLoginUserInfoByUserId(String userId) {
		AccountDto dto = new AccountDto();
		dto.setUserId(userId);
		dto.setPassword("password");
		return dto;
	}

	@Override
	public void registLoginUserInfo() {
		// TODO 登録処理を追加すること
	}

	@Override
	public void updateLoginUserInfo(LoginUserForm form) {
		// TODO 更新処理を追加すること
	}

}
