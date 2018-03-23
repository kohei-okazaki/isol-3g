package jp.co.isol.manage.controller;

import java.util.Objects;

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

import jp.co.isol.common.entity.Account;
import jp.co.isol.common.entity.MailInfo;
import jp.co.isol.common.web.manage.BaseWizardController;
import jp.co.isol.manage.config.ManageConfig;
import jp.co.isol.manage.exception.AccountSettingException;
import jp.co.isol.manage.form.AccountSettingForm;
import jp.co.isol.manage.service.AccountSearchService;
import jp.co.isol.manage.service.AccountSettingService;
import jp.co.isol.manage.service.MailInfoCreateService;
import jp.co.isol.manage.service.MailInfoSearchService;
import jp.co.isol.manage.validator.AccountSettingValidator;
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
	/** メール情報検索サービス */
	@Autowired
	private MailInfoSearchService mailInfoSearchService;
	/** メール情報作成サービス */
	@Autowired
	private MailInfoCreateService mailInfoCreateService;

	/**
	 * Validateを設定<br>
	 * @param binder
	 */
	@Override
	@InitBinder(value = "AccountSettingForm")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new AccountSettingValidator());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@GetMapping(value = "/account-setting-input.html")
	public String input(Model model, HttpServletRequest request) throws AccountSettingException {

		ManageSessionManager sessionManager;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			sessionManager = context.getBean(ManageSessionManager.class);
		}

		// セッションからユーザIDを取得
		String userId = (String) sessionManager.getAttribute(request.getSession(), ManageSessionKey.USER_ID);

		// アカウント情報を検索
		Account account = this.accountSearchService.findAccountByUserId(userId);
		model.addAttribute("account", account);

		// メール情報を検索
		MailInfo mailInfo = this.mailInfoSearchService.findMailInfoByUserId(userId);
		model.addAttribute("mailInfo", mailInfo);

		model.addAttribute("page", PageType.INPUT.getName());

		return getView(ManageView.ACCOUNT_SETTING);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	@PostMapping(value = "/account-setting-confirm.html")
	public String confirm(Model model, @Valid AccountSettingForm form, BindingResult result) throws AccountSettingException {

		if (result.hasErrors()) {
			model.addAttribute("page", PageType.INPUT.getName());
			return getView(ManageView.ACCOUNT_SETTING);
		}

		model.addAttribute("form", form);
		model.addAttribute("page", PageType.CONFIRM.getName());

		return getView(ManageView.ACCOUNT_SETTING);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@PostMapping(value = "/account-setting-complete.html")
	public String complete(Model model, AccountSettingForm form, HttpServletRequest request) throws AccountSettingException {

//		if (CodeManager.getInstance().isEquals(MainKey.FLAG, SubKey.TRUE, form.getDeleteFlag())) {
//			// アカウントを削除する場合
//			this.accountSettingService.deleteAccount(form);
//		}

		Account account = this.accountSearchService.findAccountByUserId(form.getUserId());
		account = this.accountSettingService.mergeAccount(account, form);

		MailInfo mailInfo = this.accountSettingService.convertMailInfo(form);

		// メール情報を検索
		MailInfo befMailInfo = this.mailInfoSearchService.findMailInfoByUserId(form.getUserId());
		if (Objects.isNull(befMailInfo.getUserId())) {

			// メール情報が登録されてない場合、新規登録する
			this.mailInfoCreateService.create(mailInfo);
			// アカウント情報を更新する
			this.accountSettingService.updateAccount(account);

		} else {

			befMailInfo = this.accountSettingService.mergeMailInfo(befMailInfo, form);
			// 更新処理を行う
			this.accountSettingService.update(account, befMailInfo);

		}

		model.addAttribute("page", PageType.COMPLETE.getName());

		return getView(ManageView.ACCOUNT_SETTING);
	}

}
