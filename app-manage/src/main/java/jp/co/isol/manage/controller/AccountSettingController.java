package jp.co.isol.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.isol.manage.form.AccountSettingForm;
import jp.co.isol.manage.log.ManageLogger;
import jp.co.isol.manage.service.AccountSearchService;
import jp.co.isol.manage.service.AccountSettingService;
import jp.co.isol.manage.view.PageView;
import jp.co.isol.manage.view.View;
import jp.co.isol.manage.web.config.ManageConfig;
import jp.co.isol.manage.web.session.ManageSessionKey;
import jp.co.isol.manage.web.session.ManageSessionManager;

/**
 * 健康管理_アカウント設定コントローラ<br>
 *
 */
@Controller
public class AccountSettingController {

	/** アカウント検索サービス */
	@Autowired
	private AccountSearchService accountSearchService;
	/** アカウント設定サービス */
	@Autowired
	private AccountSettingService accountSettingService;

	/**
	 * アカウント設定入力画面
	 * @param model
	 * @param request
	 * @return アカウント設定入力画面
	 */
	@RequestMapping(value = "/account-setting-input.html", method = RequestMethod.GET)
	public String accountSetttingInput(Model model, HttpServletRequest request) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class);
		ManageLogger logger = context.getBean(ManageLogger.class);
		logger.info(this.getClass(), "#accountSetttingInput start");

		// セッションからユーザIDを取得
		HttpSession session = request.getSession();
		ManageSessionManager sessionManager = context.getBean(ManageSessionManager.class);
		String userId = sessionManager.getAttribute(session, ManageSessionKey.USER_ID);

		model.addAttribute("dto", accountSearchService.findAccountByUserId(userId));

		model.addAttribute("page", PageView.INPUT.getValue());

		return View.ACCOUNT_SETTING.getName();
	}

	/**
	 * アカウント設定確認画面
	 * @param model
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/account-setting-confirm.html", method = RequestMethod.POST)
	public String accountsettingConfirm(Model model, AccountSettingForm form) {


		if (accountSettingService.invalidForm(form)) {
			// 入力情報が不正の場合
			model.addAttribute("page", PageView.INPUT.getValue());
			model.addAttribute("errorMessage", "アカウント設定の変更情報が不正です");

			return View.ACCOUNT_SETTING.getName();
		}
		model.addAttribute("form", form);
		model.addAttribute("page", PageView.CONFIRM.getValue());

		return View.ACCOUNT_SETTING.getName();
	}

	/**
	 * アカウント設定完了画面
	 * @param model
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/account-setting-complete.html", method = RequestMethod.POST)
	public String accountSettingComplete(Model model, AccountSettingForm form) {

		if (form.isDeleteFlag()) {
			// アカウントを削除する場合
			accountSettingService.deleteAccount(form);
			return View.ACCOUNT_SETTING.getName();
		}

		// アカウントを更新する
		accountSettingService.changePassword(form);

		model.addAttribute("page", PageView.COMPLETE.getValue());

		return View.ACCOUNT_SETTING.getName();
	}


}
