package jp.co.isol.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.isol.manage.log.AppLogger;
import jp.co.isol.manage.view.View;
import jp.co.isol.manage.web.config.AppConfig;
import jp.co.isol.manage.web.session.AppSessionKey;
import jp.co.isol.manage.web.session.AppSessionManager;

/**
 * @author kou1210hei<br>
 * 健康管理_ログイン画面コントローラクラス
 *
 */
@Controller
public class LoginController {

	/**
	 * ログイン画面
	 * @param locale
	 * @param model
	 * @param request
	 * @return ログイン画面
	 */
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppSessionManager sessionManager = context.getBean(AppSessionManager.class);
		sessionManager.removeKey(session, AppSessionKey.USER_ID);

		AppLogger logger = context.getBean(AppLogger.class);
		logger.info(this.getClass(), "# login start");

		return View.LOGIN.getName();
	}
}
