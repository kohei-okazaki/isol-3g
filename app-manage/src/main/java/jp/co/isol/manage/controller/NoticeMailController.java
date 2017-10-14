package jp.co.isol.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.isol.manage.form.MenuForm;
import jp.co.isol.manage.log.AppLogger;
import jp.co.isol.manage.service.MailService;
import jp.co.isol.manage.view.PageView;
import jp.co.isol.manage.view.View;
import jp.co.isol.manage.web.config.AppConfig;


/**
 * メール通知機能コントローラクラス<br>
 *
 */
@Controller
public class NoticeMailController {

	@Autowired
	private MailService mailService;

	/**
	 * メール通知実行
	 * @param req
	 * @param resp
	 * @param model
	 * @param form
	 * @return View
	 */
	@RequestMapping(value = "/menu/notice.html", method = RequestMethod.POST)
	public String execute(HttpServletRequest req, HttpServletResponse resp, Model model, MenuForm form) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppLogger logger = context.getBean(AppLogger.class);


		mailService.sendMail(form);

		model.addAttribute("page", PageView.COMPLETE.getValue());
		return View.MENU.getName();
	}
}
