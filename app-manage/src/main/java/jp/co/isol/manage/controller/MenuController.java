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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.isol.manage.form.LoginForm;
import jp.co.isol.manage.log.ManageLogger;
import jp.co.isol.manage.service.LoginService;
import jp.co.isol.manage.web.config.ManageConfig;
import jp.co.isol.manage.web.view.ManageView;

/**
 * 健康管理_メニュー画面コントローラ
 *
 */
@Controller
@RequestMapping("/menu.html")
public class MenuController {

	/** ログインサービス */
	@Autowired
	private LoginService loginService;

	/**
	 * メニュー画面
	 * @param model
	 * @param request
	 * @param loginForm
	 * @return
	 * @throws ParseException
	 */
	@PostMapping
	public String menu(Model model, HttpServletRequest request, @Valid LoginForm loginForm, BindingResult result) throws ParseException {

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
	@GetMapping
	public String menu() {
		return ManageView.MENU.getName();
	}

}