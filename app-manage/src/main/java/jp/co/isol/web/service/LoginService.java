package jp.co.isol.web.service;

import javax.servlet.http.HttpSession;

import jp.co.isol.web.form.LoginForm;

/**
 * ログインサービスインターフェース<br>
 */
public interface LoginService {

	/**
	 * ログイン情報と入力情報を照合する
	 * @param loginForm
	 * @return 判定結果
	 */
	public boolean invalidPassword(LoginForm loginForm);


	/**
	 * セッションにユーザIDを登録する
	 * @param session
	 * @param loginForm
	 */
	public void registSession(HttpSession session, String userId);


	/**
	 * アカウント情報が存在するかチェック<br>
	 * @param loginForm
	 * @return
	 */
	public boolean existAccount(LoginForm loginForm);


	/**
	 * アカウント情報が有効かどうかチェック<br>
	 * 有効でない場合true, そうでない場合false<br>
	 * @param loginForm
	 * @return
	 */
	public boolean invalidAccount(LoginForm loginForm);

}
