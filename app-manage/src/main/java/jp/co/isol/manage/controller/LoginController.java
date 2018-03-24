package jp.co.isol.manage.controller;

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

import jp.co.isol.common.web.manage.BaseController;
import jp.co.isol.manage.config.ManageConfig;
import jp.co.isol.manage.form.LoginForm;
import jp.co.isol.manage.service.LoginService;
import jp.co.isol.manage.validator.LoginValidator;
import jp.co.isol.manage.web.session.ManageSessionKey;
import jp.co.isol.manage.web.session.ManageSessionManager;
import jp.co.isol.manage.web.view.ManageView;

/**
 * 健康管理_ログイン画面コントローラクラス
 *
 */
@Controller
public class LoginController implements BaseController {

	/** ログインサービス */
	@Autowired
	private LoginService loginService;

	/**
	 * Validateを設定<br>
	 * @param binder
	 */
	@InitBinder(value = "LoginForm")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new LoginValidator());
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

		ManageSessionManager sessionManager;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			sessionManager = context.getBean(ManageSessionManager.class);
		}

		sessionManager.removeKey(request.getSession(), ManageSessionKey.USER_ID);

		return getView(ManageView.LOGIN);
	}

	/**
	 * メニュー画面
	 * @param model
	 * @param request
	 * @param loginForm
	 * @param result
	 * @return
	 */
	@PostMapping
	@RequestMapping("/menu.html")
	public String menu(Model model, HttpServletRequest request, @Valid LoginForm loginForm, BindingResult result) {

		if (result.hasErrors()) {
			// バインドエラー時の処理
			System.out.println("バインドエラーが発生");
			return ManageView.LOGIN.getName();
		}

		if (!this.loginService.existAccount(loginForm)) {
			// アカウント情報を取得出来なかった場合
			model.addAttribute("errorMessage", "アカウントが存在しません。");
			return ManageView.LOGIN.getName();
		}

		if (this.loginService.invalidPassword(loginForm)) {
			// 入力されたユーザIDと紐付くアカウント情報.パスワードと入力情報.パスワードが異なる場合
			model.addAttribute("errorMessage", "IDとパスワードが一致しません。");
			return ManageView.LOGIN.getName();
		}

		if (this.loginService.invalidAccount(loginForm)) {
			// アカウント情報が有効期限切の場合
			model.addAttribute("errorMessage", "ユーザID : " + loginForm.getUserId() + "は有効期限切れです。");
			return ManageView.LOGIN.getName();
		}

		// セッションにユーザIDを登録する。
		this.loginService.registSession(request.getSession(), loginForm.getUserId());

		return getView(ManageView.MENU);

	}

	/**
	 * getでメニュー画面に遷移する<br>
	 * @return
	 */
	@RequestMapping(value = "/menu.html", method = RequestMethod.GET)
	public String menu() {
		return getView(ManageView.MENU);
	}

}
