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
import org.springframework.web.servlet.ModelAndView;

import jp.co.isol.common.dao.HealthInfoDao;
import jp.co.isol.common.entity.HealthInfo;
import jp.co.isol.common.web.manage.BaseWizardController;
import jp.co.isol.manage.config.ManageConfig;
import jp.co.isol.manage.exception.HealthInfoException;
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
import jp.co.isol.manage.web.session.ManageSessionKey;
import jp.co.isol.manage.web.session.ManageSessionManager;
import jp.co.isol.manage.web.view.ManageView;

/**
 * 健康管理_健康情報入力画面コントローラ<br>
 *
 */
@Controller
public class HealthInfoController extends BaseWizardController<HealthInfoForm, HealthInfoException> {

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
	 * formを指定しないとなぜかDtoがvalidate対象になってしまうのでvalueにformクラスに指定する<br>
	 * @param binder
	 */
	@Override
	@InitBinder(value = "HealthInfoForm")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new HealthInfoValidator());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@GetMapping(value = "/healthInfo-input.html")
	public String input(Model model, HttpServletRequest request) throws HealthInfoException {
		return getView(ManageView.HEALTH_INFO_INPUT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@PostMapping(value = "/healthInfo-confirm.html")
	public String confirm(Model model, @Valid HealthInfoForm form, BindingResult result) throws HealthInfoException {

		if (result.hasErrors()) {
			return getView(ManageView.HEALTH_INFO_INPUT);
		}

		// 入力情報を設定
		model.addAttribute("form", form);

		return getView(ManageView.HEALTH_INFO_CONFIRM);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@PostMapping(value = "/healthInfo-complete.html")
	public String complete(Model model, HealthInfoForm form, HttpServletRequest request) throws HealthInfoException {

		ManageSessionManager manager;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			manager = context.getBean(ManageSessionManager.class);
		}

		String userId = (String) manager.getAttribute(request.getSession(), ManageSessionKey.USER_ID);

		// ユーザIDから健康情報のリストを取得
		List<HealthInfo> healthInfoList = this.healthInfoSearchService.findHealthInfoByUserId(userId);

		HealthInfo healthInfo;

		// 初回登録であるかの判定
		boolean isFirstReg = healthInfoList.isEmpty();
		model.addAttribute("isFirstReg", isFirstReg);

		if (isFirstReg) {

			healthInfo = this.healthInfoService.convertHealthInfo(form, userId, null);

		} else {

			int lastIndex = healthInfoList.size() - 1;
			// 最後に登録した健康情報を取得
			HealthInfo lastHealthInfo = healthInfoList.get(lastIndex);
			model.addAttribute("beforeWeight", lastHealthInfo.getWeight());

			// 「入力情報.体重」と前回入力した体重の差を設定
			model.addAttribute("diffWeight", this.healthInfoService.getDiffWeight(form, lastHealthInfo));

			// 「入力情報.体重」と前回入力した体重の結果からメッセージを設定
			model.addAttribute("resultMessage", this.healthInfoService.getDiffMessage(form, lastHealthInfo));

			healthInfo = this.healthInfoService.convertHealthInfo(form, userId, lastHealthInfo);
		}

		// 入力した健康情報を設定する
		model.addAttribute("healthInfo", healthInfo);

		// 入力画面から入力した情報を登録する
		this.healthInfoDao.registHealthInfo(healthInfo);

		return getView(ManageView.HEALTH_INFO_COMPLETE);
	}


	/**
	 * 健康情報Excelをダウンロードする<br>
	 * @param form
	 * @return ModelAndView
	 */
	@GetMapping(value = "/healthInfo-excelDownload.html")
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
	@GetMapping(value = "/healthInfo-csvDownload")
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
	@GetMapping(value = "/notice.html")
	public String execute(HttpServletRequest request, Model model, HealthInfoForm form) {

		ManageLogger logger;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			logger = context.getBean(ManageLogger.class);
		}
		logger.info(this.getClass(), "# mail execute start");

		this.mailService.sendMail(form);

		return getView(ManageView.HEALTH_INFO_COMPLETE);
	}

}
