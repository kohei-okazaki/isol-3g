package jp.co.isol.manage.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.isol.common.util.DateUtil;
import jp.co.isol.manage.form.LoginUserForm;
import jp.co.isol.manage.view.View;

/**
 * @author kou1210hei<br>
 * 通知設定コントローラクラス<br>
 *
 */
@Controller
public class NoticeSettingController {

	private static final Logger LOG = LoggerFactory.getLogger(AccountSettingController.class.getSimpleName());

	@RequestMapping(value = "/notice-setting.html")
	public String noticeSetttingInput(Locale locale, Model model, LoginUserForm loginForm) {

		LOG.info("-----> NoticeSettingController start");
		model.addAttribute("serverTime", DateUtil.getFormattedTime(locale));
		return View.NOTICE_SETTING.getName();
	}

}
