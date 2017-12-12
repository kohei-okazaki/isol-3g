package jp.co.isol.manage.service;

import javax.servlet.http.HttpSession;

import jp.co.isol.manage.form.LoginUserForm;

/**
 * ログインサービスIF
 */
public interface LoginService {

	/**
	 * ログイン情報と入力情報を照合する
	 * @param loginForm
	 * @return 判定結果
	 */
	public boolean invalidPassword(LoginUserForm loginForm);


	/**
	 * セッションにユーザIDを登録する
	 * @param session
	 * @param loginForm
	 */
	public void registSession(HttpSession session, String userId);

}
