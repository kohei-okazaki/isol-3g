package jp.co.isol.manage.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import jp.co.isol.manage.form.LoginUserForm;
import jp.co.isol.manage.service.AccountSearchService;
import jp.co.isol.manage.service.LoginService;
import jp.co.isol.manage.web.config.ManageConfig;
import jp.co.isol.manage.web.session.ManageSessionKey;
import jp.co.isol.manage.web.session.ManageSessionManager;

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
	 * {@inheritDoc}
	 */
	@Override
	public boolean invalidPassword(LoginUserForm LoginUserForm) {
		String inputPassword = LoginUserForm.getPassword();
		String userPassword = accountSearchService.findAccountByUserId(LoginUserForm.getUserId()).getPassword();
		return !inputPassword.equals(userPassword);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void registSession(HttpSession session, String userId) {

		ManageSessionManager sessionManager;

		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			sessionManager = context.getBean(ManageSessionManager.class);
		}

		sessionManager.setAttribute(session, ManageSessionKey.USER_ID, userId);
	}

}
