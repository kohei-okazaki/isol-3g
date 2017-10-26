package jp.co.isol.manage.dao;

import jp.co.isol.manage.dto.LoginUserDto;
import jp.co.isol.manage.form.LoginUserForm;

/**
 * @author kou1210hei<br>
 * ログインユーザ情報のDaoインターフェイス
 *
 */
public interface LoginUserDao {

	/**
	 * 引数で指定されたIDのログインユーザ情報を取得する
	 * @param id
	 * @return LoginUserEntity
	 */
	public LoginUserDto getLoginUserInfoByUserId(String userId);


	/**
	 * ログインユーザ情報を登録する
	 */
	public void registLoginUserInfo();


	/**
	 * 引数で指定されたIDのログインユーザ情報を更新する
	 * @param form
	 */
	public void updateLoginUserInfo(LoginUserForm form);

}
