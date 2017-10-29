package jp.co.isol.manage.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.isol.manage.form.LoginUserForm;
import jp.co.isol.manage.log.AppLogger;
import jp.co.isol.manage.service.LoginService;
import jp.co.isol.manage.view.View;
import jp.co.isol.manage.web.config.AppConfig;

/**
 * 健康管理_メニュー画面コントローラ
 *
 */
@Controller
public class MenuController {

	@Autowired
	private LoginService loginService;

	/**
	 * メニュー画面
	 * @param locale
	 * @param model
	 * @param form
	 * @return View
	 * @throws ParseException
	 */
	@RequestMapping(value = "/menu.html", method = RequestMethod.POST)
	public String menu(Model model, HttpServletRequest request, LoginUserForm loginForm) throws ParseException {

		if (loginService.invalidPassword(loginForm)) {
			model.addAttribute("errorMessage", "IDとパスワードが一致しません。");
			return View.LOGIN.getName();
		}
		// セッションにIDを登録する。
		loginService.registSession(request.getSession(), loginForm);

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppLogger logger = context.getBean(AppLogger.class);
		logger.info(this.getClass(), "# menu start");

		return View.MENU.getName();

	}

	/**
	 * getでメニュー画面に遷移する<br>
	 * @param locale
	 * @param model
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/menu.html", method = RequestMethod.GET)
	public String menu() {
		return View.MENU.getName();
	}

}