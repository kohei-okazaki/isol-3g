package jp.co.isol.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.isol.manage.form.LoginUserForm;
import jp.co.isol.manage.log.AppLogger;
import jp.co.isol.manage.view.PageView;
import jp.co.isol.manage.view.View;
import jp.co.isol.manage.web.config.AppConfig;
import jp.co.isol.manage.web.session.AppSessionKey;
import jp.co.isol.manage.web.session.AppSessionManager;

/**
 * 健康管理_アカウント設定コントローラ<br>
 *
 */
@Controller
public class AccountSettingController {

	/**
	 * アカウント設定入力画面
	 * @param locale
	 * @param model
	 * @param loginForm
	 * @param request
	 * @return アカウント設定入力画面
	 */
	@RequestMapping(value = "/account-setting-input.html")
	public String accountSetttingInput(Model model, LoginUserForm loginForm, HttpServletRequest request) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppLogger logger = context.getBean(AppLogger.class);
		logger.info(this.getClass(), "#accountSetttingInput start");

		// セッションからユーザIDを取得
		HttpSession session = request.getSession();
		AppSessionManager sessionManager = context.getBean(AppSessionManager.class);
		String userId = sessionManager.getAttribute(session, AppSessionKey.USER_ID);

		model.addAttribute("userId", userId);

		model.addAttribute("page", PageView.INPUT.getValue());

		return View.ACCOUNT_SETTING.getName();
	}


}
