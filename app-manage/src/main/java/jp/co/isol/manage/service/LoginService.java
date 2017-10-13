package jp.co.isol.manage.service;

import javax.servlet.http.HttpServletRequest;

import jp.co.isol.manage.form.LoginUserForm;

/**
 * @author kou1210hei<br>
 * ログインサービスクラス
 */
public interface LoginService {

	/**
	 * ログイン情報と入力情報を照合する
	 * @param loginForm
	 * @return 判定結果
	 */
	public boolean misMatch(LoginUserForm loginForm);


	/**
	 * セッションにユーザのIDを登録する
	 * @param request
	 * @param loginForm
	 */
	public void registSession(HttpServletRequest request, LoginUserForm loginForm);

}
