package jp.co.isol.manage.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.isol.manage.form.LoginForm;
import jp.co.isol.manage.log.ManageLogger;
import jp.co.isol.manage.web.config.ManageConfig;
import jp.co.isol.manage.web.view.ManageView;

/**
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
	@GetMapping
	@RequestMapping(value = "/notice-setting.html")
	public String input(Model model, LoginForm loginForm) {

		ManageLogger logger;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			logger = context.getBean(ManageLogger.class);
		}
		logger.info(this.getClass(), "# noticeSetttingInput start");

		return ManageView.NOTICE_SETTING.getName();
	}

}
