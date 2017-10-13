package jp.co.isol.manage.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.isol.common.util.DateUtil;
import jp.co.isol.manage.form.LoginUserForm;
import jp.co.isol.manage.view.PageView;
import jp.co.isol.manage.view.View;
import jp.co.isol.manage.web.session.AppSessionKey;
import jp.co.isol.manage.web.session.AppSessionManager;

/**
 * 健康管理_アカウント設定コントローラ
 *
 */
@Controller
public class AccountSettingController {

	private static final Logger LOG = LoggerFactory.getLogger(AccountSettingController.class.getSimpleName());

	/**
	 * 設定画面
	 * @param locale
	 * @param model
	 * @param loginForm
	 * @param request
	 * @return アカウント設定画面
	 */
	@RequestMapping(value = "/account-setting.html")
	public String accountSetttingInput(Locale locale, Model model, LoginUserForm loginForm, HttpServletRequest request) {

		LOG.info("-----> AccountSettingController start");

		model.addAttribute("serverTime", DateUtil.getFormattedTime(locale));

		// セッションからIDを取得
		HttpSession session = request.getSession();
		String id = AppSessionManager.getInstance().getValue(session, AppSessionKey.ID);

		model.addAttribute("id", id);

		model.addAttribute("page", PageView.INPUT.getValue());

		return View.ACCOUNT_SETTING.getName();
	}


}
