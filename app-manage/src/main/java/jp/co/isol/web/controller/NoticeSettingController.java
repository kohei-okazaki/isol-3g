package jp.co.isol.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.isol.common.web.manage.BaseWizardController;
import jp.co.isol.web.exception.NoticeSettingException;
import jp.co.isol.web.form.NoticeSettingForm;
import jp.co.isol.web.validator.NoticeSettingValidator;
import jp.co.isol.web.view.ManageView;

/**
 * 健康管理_通知設定コントローラクラス<br>
 *
 */
@Controller
public class NoticeSettingController implements BaseWizardController<NoticeSettingForm, NoticeSettingException> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	@InitBinder(value = "NoticeSettingForm")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new NoticeSettingValidator());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@GetMapping
	@RequestMapping(value = "/notice-setting-input.html")
	public String input(Model model, HttpServletRequest request) throws NoticeSettingException {
		return getView(ManageView.NOTICE_SETTING_INPUT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@PostMapping
	@RequestMapping(value = "/notice-setting-confirm.html")
	public String confirm(Model model, @Valid NoticeSettingForm form, BindingResult result) throws NoticeSettingException {

		if (result.hasErrors()) {
			return getView(ManageView.NOTICE_SETTING_INPUT);
		}

		return getView(ManageView.NOTICE_SETTING_CONFIRM);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@PostMapping
	@RequestMapping(value = "/notice-setting-complete.html")
	public String complete(Model model, NoticeSettingForm form, HttpServletRequest request) throws NoticeSettingException {
		return getView(ManageView.NOTICE_SETTING_COMPLETE);
	}

}
