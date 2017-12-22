package jp.co.isol.manage.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.isol.manage.form.LoginForm;
import jp.co.isol.manage.log.ManageLogger;
import jp.co.isol.manage.service.LoginService;
import jp.co.isol.manage.validator.LoginFormValidator;
import jp.co.isol.manage.web.config.ManageConfig;
import jp.co.isol.manage.web.session.ManageSessionKey;
import jp.co.isol.manage.web.session.ManageSessionManager;
import jp.co.isol.manage.web.view.ManageView;

/**
 * 健康管理_ログイン画面コントローラクラス
 *
 */
@Controller
public class LoginController {

	/** ログインサービス */
	@Autowired
	private LoginService loginService;

	/**
	 * Validateを設定<br>
	 * @param binder
	 */
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.setValidator(new LoginFormValidator());
	}

	/**
	 * ログイン画面
	 * @param model
	 * @param request
	 * @return ログイン画面
	 */
	@GetMapping
	@RequestMapping("/login.html")
	public String input(Model model, HttpServletRequest request) {

		ManageLogger logger;
		ManageSessionManager sessionManager;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			logger = context.getBean(ManageLogger.class);
			sessionManager = context.getBean(ManageSessionManager.class);
		}

		sessionManager.removeKey(request.getSession(), ManageSessionKey.USER_ID);
		logger.info(this.getClass(), "# login start");

		return ManageView.LOGIN.getName();
	}

	/**
	 * メニュー画面
	 * @param model
	 * @param request
	 * @param loginForm
	 * @return
	 * @throws ParseException
	 */
	@PostMapping
	@RequestMapping("/menu.html")
	public String menu(Model model, HttpServletRequest request, @Valid LoginForm loginForm, BindingResult result) throws ParseException {

		if (result.hasErrors()) {
			// バインドエラー時の処理
			System.out.println("バインドエラーが発生");
			return ManageView.LOGIN.getName();
		}

		if (this.loginService.invalidPassword(loginForm)) {
			model.addAttribute("errorMessage", "IDとパスワードが一致しません。");
			return ManageView.LOGIN.getName();
		}
		// セッションにユーザIDを登録する。
		this.loginService.registSession(request.getSession(), loginForm.getUserId());

		ManageLogger logger;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			logger = context.getBean(ManageLogger.class);
		}
		logger.info(this.getClass(), "# menu start");

		return ManageView.MENU.getName();

	}

	/**
	 * getでメニュー画面に遷移する<br>
	 * @return
	 */
	@RequestMapping(value = "/menu.html", method = RequestMethod.GET)
	public String menu() {
		return ManageView.MENU.getName();
	}

}
