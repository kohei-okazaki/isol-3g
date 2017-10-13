package jp.co.isol.manage.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import jp.co.isol.manage.form.LoginUserForm;
import jp.co.isol.manage.service.LoginService;
import jp.co.isol.manage.service.LoginUserSearchService;
import jp.co.isol.manage.web.config.AppConfig;
import jp.co.isol.manage.web.session.AppSessionKey;
import jp.co.isol.manage.web.session.AppSessionManager;

/**
 * @author kou1210hei<br>
 * ログインサービス実装クラス
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginUserSearchService loginSearchService;

	/**
	 * ログイン情報と入力情報を照合する
	 * @param LoginUserForm
	 * @return 判定結果
	 */
	@Override
	public boolean misMatch(LoginUserForm LoginUserForm) {

		String inputPassword = LoginUserForm.getPassword();
		String userPassword = loginSearchService.getLoginUserEntity(LoginUserForm.getId()).getPassword();
		return !inputPassword.equals(userPassword);
	}

	/**
	 * セッションにユーザのIDを登録する
	 * @param request
	 * @param loginForm
	 */
	@Override
	public void registSession(HttpServletRequest request, LoginUserForm loginForm) {
		HttpSession session = request.getSession();
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppSessionManager sessionManager = context.getBean("appSessionManager", AppSessionManager.class);
		sessionManager.setAttribute(session, AppSessionKey.ID, loginForm.getId());
	}

}
