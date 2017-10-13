package jp.co.isol.manage.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.isol.manage.view.View;
import jp.co.isol.manage.web.config.AppConfig;
import jp.co.isol.manage.web.session.AppSessionKey;
import jp.co.isol.manage.web.session.AppSessionManager;

/**
 * @author kou1210hei<br>
 * ログイン画面コントローラクラス
 *
 */
@Controller
public class LoginController {

	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class.getSimpleName());


	/**
	 * ログイン画面
	 * @param locale
	 * @param model
	 * @param request
	 * @return ログイン画面
	 */
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login(Locale locale, Model model, HttpServletRequest request) {

		LOG.info("---> LoginController start");

		HttpSession session = request.getSession();
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppSessionManager sessionManager = context.getBean("appSessionManager", AppSessionManager.class);
		sessionManager.removeKey(session, AppSessionKey.ID);

		return View.LOGIN.getName();
	}
}
