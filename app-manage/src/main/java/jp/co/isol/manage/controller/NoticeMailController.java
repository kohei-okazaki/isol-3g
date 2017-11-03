package jp.co.isol.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jp.co.isol.manage.service.MailService;


/**
 * 健康管理_メール通知機能コントローラクラス<br>
 *
 */
@Controller
public class NoticeMailController {

	@Autowired
	private MailService mailService;

//	/**
//	 * メール通知実行
//	 * @param req
//	 * @param resp
//	 * @param model
//	 * @param form
//	 * @return View
//	 */
//	@RequestMapping(value = "/notice.html", method = RequestMethod.GET)
//	public String execute(HttpServletRequest req, HttpServletResponse resp, Model model, HealthInfoInputForm form) {
//
//		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//		AppLogger logger = context.getBean(AppLogger.class);
//		logger.info(this.getClass(), "# mail execute start");
//
//		mailService.sendMail(form);
//
//		model.addAttribute("page", PageView.COMPLETE.getValue());
//		return View.MENU.getName();
//	}
}
