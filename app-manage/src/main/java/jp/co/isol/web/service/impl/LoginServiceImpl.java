package jp.co.isol.web.service.impl;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import jp.co.isol.common.entity.Account;
import jp.co.isol.common.manager.CodeManager;
import jp.co.isol.common.manager.MainKey;
import jp.co.isol.common.manager.SubKey;
import jp.co.isol.web.config.ManageConfig;
import jp.co.isol.web.form.LoginForm;
import jp.co.isol.web.service.AccountSearchService;
import jp.co.isol.web.service.LoginService;
import jp.co.isol.web.web.session.ManageSessionKey;
import jp.co.isol.web.web.session.ManageSessionManager;

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
	public boolean invalidPassword(LoginForm loginForm) {
		String inputPassword = loginForm.getPassword();
		Account account = accountSearchService.findAccountByUserId(loginForm.getUserId());
		String userPassword = account.getPassword();
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existAccount(LoginForm loginForm) {

		Account account = accountSearchService.findAccountByUserId(loginForm.getUserId());
		return Objects.nonNull(account.getUserId());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean invalidAccount(LoginForm loginForm) {

		Account account = accountSearchService.findAccountByUserId(loginForm.getUserId());
		return CodeManager.getInstance().isEquals(MainKey.FLAG, SubKey.TRUE, account.getDeleteFlag());
	}

}
