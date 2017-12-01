package jp.co.isol.manage.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.isol.manage.form.LoginUserForm;
import jp.co.isol.manage.log.ManageLogger;
import jp.co.isol.manage.service.LoginService;
import jp.co.isol.manage.view.View;
import jp.co.isol.manage.web.config.ManageConfig;

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
	public String menu(Model model, HttpServletRequest request, LoginUserForm loginForm) throws ParseException {

		if (loginService.invalidPassword(loginForm)) {
			model.addAttribute("errorMessage", "IDとパスワードが一致しません。");
			return View.LOGIN.getName();
		}
		// セッションにユーザIDを登録する。
		loginService.registSession(request.getSession(), loginForm.getUserId());

		ManageLogger logger;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			logger = context.getBean(ManageLogger.class);
		}
		logger.info(this.getClass(), "# menu start");

		return View.MENU.getName();

	}

	/**
	 * getでメニュー画面に遷移する<br>
	 * @return
	 */
	@GetMapping
	public String menu() {
		return View.MENU.getName();
	}

}