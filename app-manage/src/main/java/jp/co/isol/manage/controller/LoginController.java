package jp.co.isol.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.isol.manage.log.ManageLogger;
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
@RequestMapping("/login.html")
public class LoginController {

	/**
	 * ログイン画面
	 * @param model
	 * @param request
	 * @return ログイン画面
	 */
	@GetMapping
	public String login(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppSessionManager sessionManager = context.getBean(AppSessionManager.class);
		sessionManager.removeKey(session, AppSessionKey.USER_ID);

		ManageLogger logger = context.getBean(ManageLogger.class);
		logger.info(this.getClass(), "# login start");

		return View.LOGIN.getName();
	}
}
