package jp.co.isol.manage.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.isol.common.util.DateUtil;
import jp.co.isol.manage.form.LoginUserForm;
import jp.co.isol.manage.form.MenuForm;
import jp.co.isol.manage.log.AppLogger;
import jp.co.isol.manage.service.InputService;
import jp.co.isol.manage.service.LoginService;
import jp.co.isol.manage.view.PageView;
import jp.co.isol.manage.view.View;
import jp.co.isol.manage.web.config.AppConfig;

/**
 * 健康管理_入力画面コントローラ
 *
 */
@Controller
public class InputController {

	@Autowired
	private InputService inputService;
	@Autowired
	private LoginService loginService;

	/**
	 * 入力画面
	 * @param locale
	 * @param model
	 * @param loginForm
	 * @param request
	 * @return 遷移先を返却
	 */
	@RequestMapping(value = "/input.html", method = RequestMethod.POST)
	public String input(Locale locale, Model model, LoginUserForm loginForm, HttpServletRequest request) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppLogger logger = context.getBean(AppLogger.class);
		logger.info(this.getClass(), "#input start");

		if (loginService.invalidPassword(loginForm)) {
			model.addAttribute("errorMessage", "IDとパスワードが一致しません。");
			return View.LOGIN.getName();
		}

		// セッションにIDを登録する。
		loginService.registSession(request.getSession(), loginForm);

		// 時刻取得
		model.addAttribute("serverTime", DateUtil.getFormattedTime(locale));

		// 入力フォームの初期化
		model.addAttribute("menuForm", new MenuForm());

		model.addAttribute("page", PageView.INPUT.getValue());

		return View.INPUT.getName();
	}

	/**
	 * 確認画面
	 * @param locale
	 * @param model
	 * @param form
	 * @return 確認画面
	 */
	@RequestMapping(value = "/input-confirm.html", method = RequestMethod.POST)
	public String confirm(Locale locale, Model model, MenuForm form) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppLogger logger = context.getBean(AppLogger.class);
		logger.info(this.getClass(), "#confirm start");

		// 時刻取得
		model.addAttribute("serverTime", DateUtil.getFormattedTime(locale));

		if (inputService.hasError(form)) {
			// 入力情報に誤りがある場合
			logger.warn(this.getClass(), "入力情報に誤りがあります");
			return View.ERROR.getName();
		}

		// 入力情報を設定
		model.addAttribute("form", form);

		model.addAttribute("page", PageView.CONFIRM.getValue());

		return View.INPUT.getName();
	}

}
