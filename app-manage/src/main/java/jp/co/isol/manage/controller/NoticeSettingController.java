package jp.co.isol.manage.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.isol.manage.form.LoginUserForm;
import jp.co.isol.manage.log.AppLogger;
import jp.co.isol.manage.view.View;
import jp.co.isol.manage.web.config.AppConfig;

/**
 * @author kou1210hei<br>
 * 健康管理_通知設定コントローラクラス<br>
 *
 */
@Controller
public class NoticeSettingController {

	/**
	 * 通知設定入力画面
	 * @param model
	 * @param loginForm
	 * @return
	 */
	@RequestMapping(value = "/notice-setting.html")
	public String noticeSetttingInput(Model model, LoginUserForm loginForm) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppLogger logger = context.getBean(AppLogger.class);
		logger.info(this.getClass(), "# noticeSetttingInput start");

		return View.NOTICE_SETTING.getName();
	}

}
