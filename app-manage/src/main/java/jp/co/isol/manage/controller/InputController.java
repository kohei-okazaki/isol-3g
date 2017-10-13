package jp.co.isol.manage.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.isol.common.util.DateUtil;
import jp.co.isol.manage.form.LoginUserForm;
import jp.co.isol.manage.form.MenuForm;
import jp.co.isol.manage.service.InputService;
import jp.co.isol.manage.service.LoginService;
import jp.co.isol.manage.view.PageView;
import jp.co.isol.manage.view.View;

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

	private static final Logger LOG = LoggerFactory.getLogger(InputController.class.getSimpleName());

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

		LOG.info("---> InputController start");

		if (loginService.misMatch(loginForm)) {
			model.addAttribute("errorMessage", "IDとパスワードが一致しません。");
			return View.LOGIN.getName();
		}

		// セッションにIDを登録する。
		loginService.registSession(request, loginForm);

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

		LOG.info("[INFO] -----> confirm");

		// 時刻取得
		model.addAttribute("serverTime", DateUtil.getFormattedTime(locale));

		// 入力情報を設定
		model.addAttribute("form", form);

		model.addAttribute("page", PageView.CONFIRM.getValue());

		return inputService.hasError(form) ? View.ERROR.getName() : View.INPUT.getName();
	}

}
