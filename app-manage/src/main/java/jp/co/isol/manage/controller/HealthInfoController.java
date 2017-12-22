package jp.co.isol.manage.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.servlet.ModelAndView;

import jp.co.isol.common.dao.HealthInfoDao;
import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.common.mvc.BaseWizardController;
import jp.co.isol.manage.form.HealthInfoForm;
import jp.co.isol.manage.log.ManageLogger;
import jp.co.isol.manage.service.CsvDownloadService;
import jp.co.isol.manage.service.ExcelDownloadService;
import jp.co.isol.manage.service.HealthInfoSearchService;
import jp.co.isol.manage.service.HealthInfoService;
import jp.co.isol.manage.service.MailService;
import jp.co.isol.manage.service.annotation.HealthInfoCsv;
import jp.co.isol.manage.service.annotation.HealthInfoExcel;
import jp.co.isol.manage.validator.HealthInfoValidator;
import jp.co.isol.manage.web.config.ManageConfig;
import jp.co.isol.manage.web.session.ManageSessionKey;
import jp.co.isol.manage.web.session.ManageSessionManager;
import jp.co.isol.manage.web.view.ManageView;
import jp.co.isol.manage.web.view.PageType;

/**
 * 健康管理_健康情報入力画面コントローラ
 *
 */
@Controller
public class HealthInfoController extends BaseWizardController<HealthInfoForm> {

	/** 健康情報入力サービス */
	@Autowired
	private HealthInfoService healthInfoService;
	/** 健康情報Dao */
	@Autowired
	private HealthInfoDao healthInfoDao;
	/** 健康情報検索サービス */
	@Autowired
	private HealthInfoSearchService healthInfoSearchService;
	/** 健康情報Excelダウンロードサービス */
	@Autowired
	@HealthInfoExcel
	private ExcelDownloadService<HealthInfoForm> excelDownloadService;
	/** 健康情報CSVダウンロードサービス */
	@Autowired
	@HealthInfoCsv
	private CsvDownloadService csvDownloadService;
	/** メールサービス */
	@Autowired
	private MailService mailService;

	/**
	 * Validateを設定<br>
	 * @param binder
	 */
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.setValidator(new HealthInfoValidator());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@GetMapping
	@RequestMapping(value = "/healthInfo-input.html")
	public String input(Model model, HttpServletRequest request) {

		ManageLogger logger;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			logger = context.getBean(ManageLogger.class);
		}
		logger.info(this.getClass(), "#input start");

		model.addAttribute("page", PageType.INPUT.getValue());

		return ManageView.HEALTH_INFO.getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@PostMapping
	@RequestMapping(value = "/healthInfo-confirm.html")
	public String confirm(Model model, @Valid HealthInfoForm form, BindingResult result) {

		ManageLogger logger;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			logger = context.getBean(ManageLogger.class);
		}
		logger.info(this.getClass(), "#confirm start");

		if (this.healthInfoService.hasError(form)) {
			// 入力情報に誤りがある場合
			logger.warn(this.getClass(), "入力情報に誤りがあります");
			return ManageView.ERROR.getName();
		}

		// 入力情報を設定
		model.addAttribute("form", form);

		model.addAttribute("page", PageType.CONFIRM.getValue());

		return ManageView.HEALTH_INFO.getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@PostMapping
	@RequestMapping(value = "/healthInfo-complete.html")
	public String complete(Model model, HealthInfoForm form, HttpServletRequest request) throws ParseException {

		ManageLogger logger;
		ManageSessionManager manager;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			logger = context.getBean(ManageLogger.class);
			manager = context.getBean(ManageSessionManager.class);
		}
		logger.info(this.getClass(), "# menu complete");

		String userId = manager.getAttribute(request.getSession(), ManageSessionKey.USER_ID);

		HealthInfoDto dto = this.healthInfoService.convertHealthInfoDto(form, userId);

		// 入力画面から入力した情報を登録する
		this.healthInfoDao.registHealthInfo(dto);

		// ユーザIDから健康情報のリストを取得
		List<HealthInfoDto> dtoList = this.healthInfoSearchService.findHealthInfoByUserId(userId);

		// 最後に入力した体重をセット
		int lastIndex = dtoList.size() - 1;
		HealthInfoDto lastDto = dtoList.get(lastIndex);
		model.addAttribute("beforeWeight", lastDto.getWeight());

		// Dtoを設定する
		model.addAttribute("dto", dto);

		// 入力した今の体重と前回入力した体重の差を設定
		model.addAttribute("diffWeight", this.healthInfoService.getDiffWeight(form, lastDto));

		// 「入力情報.体重」と前回入力した体重の結果からメッセージを設定
		model.addAttribute("resultMessage", this.healthInfoService.getDiffMessage(form, lastDto));

		model.addAttribute("page", PageType.COMPLETE.getValue());

		return ManageView.HEALTH_INFO.getName();
	}


	/**
	 * 健康情報Excelをダウンロードする<br>
	 * @param form
	 * @return ModelAndView
	 */
	@GetMapping
	@RequestMapping(value = "/healthInfo-excelDownload.html")
	public ModelAndView excelDownload(HealthInfoForm form) {

		ManageLogger logger;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			logger = context.getBean(ManageLogger.class);
		}
		logger.info(this.getClass(), "# excelDownload start");

		return new ModelAndView(this.excelDownloadService.execute(form));

	}

	/**
	 * 健康情報CSVをダウンロードする<br>
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	@GetMapping
	@RequestMapping(value = "/healthInfo-csvDownload")
	public void csvDownload(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {

		ManageLogger logger;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			logger = context.getBean(ManageLogger.class);
		}
		logger.info(this.getClass(), "# csvDownload start");

		this.csvDownloadService.execute(request, response);

	}

	/**
	 * メール通知実行
	 * @param request
	 * @param model
	 * @param form
	 * @return View
	 */
	@GetMapping
	@RequestMapping(value = "/notice.html")
	public String execute(HttpServletRequest request, Model model, HealthInfoForm form) {

		ManageLogger logger;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			logger = context.getBean(ManageLogger.class);
		}
		logger.info(this.getClass(), "# mail execute start");

		this.mailService.sendMail(form);

		model.addAttribute("page", PageType.COMPLETE.getValue());

		return ManageView.MENU.getName();
	}

}
