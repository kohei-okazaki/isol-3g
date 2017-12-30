package jp.co.isol.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.isol.common.web.mvc.BaseWizardController;
import jp.co.isol.manage.exception.AccountSettingException;
import jp.co.isol.manage.form.AccountSettingForm;
import jp.co.isol.manage.log.ManageLogger;
import jp.co.isol.manage.service.AccountSearchService;
import jp.co.isol.manage.service.AccountSettingService;
import jp.co.isol.manage.validator.AccountSettingValidator;
import jp.co.isol.manage.web.config.ManageConfig;
import jp.co.isol.manage.web.session.ManageSessionKey;
import jp.co.isol.manage.web.session.ManageSessionManager;
import jp.co.isol.manage.web.view.ManageView;
import jp.co.isol.manage.web.view.PageType;

/**
 * 健康管理_アカウント設定コントローラ<br>
 *
 */
@Controller
public class AccountSettingController extends BaseWizardController<AccountSettingForm, AccountSettingException> {

	/** アカウント検索サービス */
	@Autowired
	private AccountSearchService accountSearchService;
	/** アカウント設定サービス */
	@Autowired
	private AccountSettingService accountSettingService;

	/**
	 * Validateを設定<br>
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new AccountSettingValidator());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@GetMapping
	@RequestMapping(value = "/account-setting-input.html")
	public String input(Model model, HttpServletRequest request) {

		ManageLogger logger;
		ManageSessionManager sessionManager;

		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			logger = context.getBean(ManageLogger.class);
			sessionManager = context.getBean(ManageSessionManager.class);
		}
		logger.info(this.getClass(), "#accountSetttingInput start");

		// セッションからユーザIDを取得
		String userId = sessionManager.getAttribute(request.getSession(), ManageSessionKey.USER_ID);

		model.addAttribute("dto", this.accountSearchService.findAccountByUserId(userId));

		model.addAttribute("page", PageType.INPUT.getValue());

		return ManageView.ACCOUNT_SETTING.getName();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	@PostMapping
	@RequestMapping(value = "/account-setting-confirm.html")
	public String confirm(Model model, @Valid AccountSettingForm form, BindingResult result) {

		if (result.hasErrors()) {
			model.addAttribute("page", PageType.INPUT.getValue());
			return ManageView.ACCOUNT_SETTING.getName();
		}

		if (this.accountSettingService.invalidForm(form)) {
			// 入力情報が不正の場合
			model.addAttribute("page", PageType.INPUT.getValue());
			model.addAttribute("errorMessage", "アカウント設定の変更情報が不正です");

			return ManageView.ACCOUNT_SETTING.getName();
		}
		model.addAttribute("form", form);
		model.addAttribute("page", PageType.CONFIRM.getValue());

		return ManageView.ACCOUNT_SETTING.getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@PostMapping
	@RequestMapping(value = "/account-setting-complete.html")
	public String complete(Model model, AccountSettingForm form, HttpServletRequest request) {

		if (form.isDeleteFlag()) {
			// アカウントを削除する場合
			this.accountSettingService.deleteAccount(form);
		}

		// アカウントを更新する
		this.accountSettingService.updateAccount(form);

		model.addAttribute("page", PageType.COMPLETE.getValue());

		return ManageView.ACCOUNT_SETTING.getName();
	}


}
