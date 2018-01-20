package jp.co.isol.manage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.isol.common.web.mvc.BaseWizardController;
import jp.co.isol.manage.exception.AccountCreateException;
import jp.co.isol.manage.form.AccountCreateForm;
import jp.co.isol.manage.service.AccountCreateService;
import jp.co.isol.manage.validator.AccountCreateValidator;
import jp.co.isol.manage.web.view.ManageView;
import jp.co.isol.manage.web.view.PageType;

/**
 * 健康管理_アカウント作成コントローラ<br>
 *
 */
@Controller
public class AccounCreateController extends BaseWizardController<AccountCreateForm, AccountCreateException>{

	/** アカウント作成サービス */
	@Autowired
	private AccountCreateService accountCreateService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@InitBinder("AccountCreateForm")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new AccountCreateValidator());

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@GetMapping(value = "account-create-input.html")
	public String input(Model model, HttpServletRequest request) throws AccountCreateException {

		model.addAttribute("page", PageType.INPUT.getName());
		return ManageView.ACCOUNT_CREATE.getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@PostMapping(value = "/account-create-confirm.html")
	public String confirm(Model model, AccountCreateForm form, BindingResult result) throws AccountCreateException {

		if (result.hasErrors()) {
			// validatationエラーの場合
			model.addAttribute("page", PageType.INPUT.getName());
			return ManageView.ACCOUNT_CREATE.getName();
		}

		model.addAttribute("form", form);
		model.addAttribute("page", PageType.CONFIRM.getName());

		return ManageView.ACCOUNT_CREATE.getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@PostMapping(value = "/account-create-complete.html")
	public String complete(Model model, AccountCreateForm form, HttpServletRequest request) throws AccountCreateException {

		// アカウント作成
		accountCreateService.create(form);

		model.addAttribute("page", PageType.COMPLETE.getName());

		return ManageView.ACCOUNT_CREATE.getName();
	}

}
