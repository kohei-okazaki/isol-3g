package jp.co.isol.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
import jp.co.isol.manage.config.ManageConfig;
import jp.co.isol.manage.exception.NoticeSettingException;
import jp.co.isol.manage.form.NoticeSettingForm;
import jp.co.isol.manage.log.ManageLogger;
import jp.co.isol.manage.validator.NoticeSettingValidator;
import jp.co.isol.manage.web.view.ManageView;
import jp.co.isol.manage.web.view.PageType;

/**
 * 健康管理_通知設定コントローラクラス<br>
 *
 */
@Controller
public class NoticeSettingController extends BaseWizardController<NoticeSettingForm, NoticeSettingException> {

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

		ManageLogger logger;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			logger = context.getBean(ManageLogger.class);
		}
		logger.info(this.getClass(), "# noticeSettingInput start");

		model.addAttribute("page", PageType.INPUT.getValue());

		return ManageView.NOTICE_SETTING.getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@PostMapping
	@RequestMapping(value = "/notice-setting-confirm.html")
	public String confirm(Model model, @Valid NoticeSettingForm form, BindingResult result) throws NoticeSettingException {

		if (result.hasErrors()) {
			model.addAttribute("page", PageType.INPUT.getValue());
			return ManageView.NOTICE_SETTING.getName();
		}

		ManageLogger logger;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			logger = context.getBean(ManageLogger.class);
		}
		logger.info(this.getClass(), "# confirm start");

		model.addAttribute("page", PageType.CONFIRM.getValue());

		return ManageView.NOTICE_SETTING.getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@PostMapping
	@RequestMapping(value = "/notice-setting-complete.html")
	public String complete(Model model, NoticeSettingForm form, HttpServletRequest request) throws NoticeSettingException {

		ManageLogger logger;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			logger = context.getBean(ManageLogger.class);
		}
		logger.info(this.getClass(), "# complete start");

		model.addAttribute("page", PageType.COMPLETE.getValue());

		return ManageView.NOTICE_SETTING.getName();
	}

}
