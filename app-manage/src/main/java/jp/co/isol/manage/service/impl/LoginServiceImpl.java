package jp.co.isol.manage.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import jp.co.isol.manage.form.LoginUserForm;
import jp.co.isol.manage.service.AccountSearchService;
import jp.co.isol.manage.service.LoginService;
import jp.co.isol.manage.web.config.ManageConfig;
import jp.co.isol.manage.web.session.AppSessionKey;
import jp.co.isol.manage.web.session.AppSessionManager;

/**
 * ログインサービス実装クラス
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	/** アカウント検索サービス */
	@Autowired
	private AccountSearchService accountSearchService;

	/**
	 * ログイン情報と入力情報を照合する
	 * @param LoginUserForm
	 * @return 判定結果
	 */
	@Override
	public boolean invalidPassword(LoginUserForm LoginUserForm) {
		String inputPassword = LoginUserForm.getPassword();
		String userPassword = accountSearchService.findAccountByUserId(LoginUserForm.getUserId()).getPassword();
		return !inputPassword.equals(userPassword);
	}

	/**
	 * セッションにユーザのIDを登録する
	 * @param session
	 * @param loginForm
	 */
	@Override
	public void registSession(HttpSession session, LoginUserForm loginForm) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class);
		AppSessionManager sessionManager = context.getBean(AppSessionManager.class);
		sessionManager.setAttribute(session, AppSessionKey.USER_ID, loginForm.getUserId());
	}

}
