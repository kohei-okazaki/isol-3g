package jp.co.isol.manage.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.isol.common.dao.HealthInfoDao;
import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.manage.form.HealthInfoForm;
import jp.co.isol.manage.log.ManageLogger;
import jp.co.isol.manage.service.FileDownloadService;
import jp.co.isol.manage.service.HealthInfoInputService;
import jp.co.isol.manage.service.HealthInfoSearchService;
import jp.co.isol.manage.service.MailService;
import jp.co.isol.manage.service.annotation.HealthInfoInput;
import jp.co.isol.manage.view.PageView;
import jp.co.isol.manage.view.View;
import jp.co.isol.manage.web.config.ManageConfig;
import jp.co.isol.manage.web.session.AppSessionKey;
import jp.co.isol.manage.web.session.AppSessionManager;

/**
 * 健康管理_健康情報入力画面コントローラ
 *
 */
@Controller
public class HealthInfoController {

	/** 健康情報入力サービス */
	@Autowired
	private HealthInfoInputService healthInfoInputService;
	/** 健康情報Dao */
	@Autowired
	private HealthInfoDao healthInfoDao;
	/** 健康情報検索サービス */
	@Autowired
	private HealthInfoSearchService healthInfoSearchService;
	/** 健康情報ファイルダウンロードサービス */
	@Autowired
	@HealthInfoInput
	private FileDownloadService<HealthInfoForm> fileDownloadService;
	/** メールサービス */
	@Autowired
	private MailService mailService;

	/**
	 * 入力画面
	 * @param model
	 * @return 遷移先を返却
	 */
	@RequestMapping(value = "/healthInfo-input.html", method = RequestMethod.GET)
	public String input(Model model) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class);
		ManageLogger logger = context.getBean(ManageLogger.class);
		logger.info(this.getClass(), "#input start");

		model.addAttribute("page", PageView.INPUT.getValue());

		return View.HEALTH_INFO_INPUT.getName();
	}

	/**
	 * 確認画面
	 * @param model
	 * @param form
	 * @return 確認画面
	 */
	@RequestMapping(value = "/healthInfo-confirm.html", method = RequestMethod.POST)
	public String confirm(Model model, HealthInfoForm form) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class);
		ManageLogger logger = context.getBean(ManageLogger.class);
		logger.info(this.getClass(), "#confirm start");

		if (healthInfoInputService.hasError(form)) {
			// 入力情報に誤りがある場合
			logger.warn(this.getClass(), "入力情報に誤りがあります");
			return View.ERROR.getName();
		}

		// 入力情報を設定
		model.addAttribute("form", form);

		model.addAttribute("page", PageView.CONFIRM.getValue());

		return View.HEALTH_INFO_INPUT.getName();
	}

	/**
	 * 完了画面
	 * @param model
	 * @param form
	 * @param request
	 * @return 完了画面
	 * @throws ParseException
	 */
	@RequestMapping(value = "/healthInfo-complete.html", method = RequestMethod.POST)
	public String complete(Model model, HealthInfoForm form, HttpServletRequest request) throws ParseException {

		ApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class);
		ManageLogger logger = context.getBean(ManageLogger.class);
		logger.info(this.getClass(), "# menu complete");

		AppSessionManager manager = context.getBean(AppSessionManager.class);
		String userId = manager.getAttribute(request.getSession(), AppSessionKey.USER_ID);

		HealthInfoDto dto = healthInfoInputService.convertUserInfo(form, userId);

		// 入力画面から入力した情報を登録する
		healthInfoDao.registHealthInfo(dto);

		// ユーザIDから健康情報のリストを取得
		List<HealthInfoDto> dtoList = healthInfoSearchService.findHealthInfoByUserId(userId);

		// 最後に入力した体重をセット
		int lastIndex = dtoList.size() - 1;
		HealthInfoDto lastDto = dtoList.get(lastIndex);
		model.addAttribute("beforeWeight", lastDto.getWeight());

		// Dtoを設定する
		model.addAttribute("dto", dto);

		// 入力した今の体重と前回入力した体重の差を設定
		model.addAttribute("diffWeight", healthInfoInputService.getDiffWeight(form, lastDto));

		// 「入力情報.体重」と前回入力した体重の結果からメッセージを設定
		model.addAttribute("resultMessage", healthInfoInputService.getDiffMessage(form, lastDto));

		model.addAttribute("page", PageView.COMPLETE.getValue());
		return View.HEALTH_INFO_INPUT.getName();
	}


	/**
	 * エクセルをダウンロードする<br>
	 * @param model
	 * @param form
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/healthInfo-fileDownload.html", method = RequestMethod.GET)
	public ModelAndView excelDownload(Map<String, Object> model, HealthInfoForm form) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class);
		ManageLogger logger = context.getBean(ManageLogger.class);
		logger.info(this.getClass(), "# excelDownload start");

		return new ModelAndView(fileDownloadService.execute(form));

	}

	/**
	 * メール通知実行
	 * @param req
	 * @param resp
	 * @param model
	 * @param form
	 * @return View
	 */
	@RequestMapping(value = "/notice.html", method = RequestMethod.GET)
	public String execute(HttpServletRequest req, HttpServletResponse resp, Model model, HealthInfoForm form) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class);
		ManageLogger logger = context.getBean(ManageLogger.class);
		logger.info(this.getClass(), "# mail execute start");

		mailService.sendMail(form);

		model.addAttribute("page", PageView.COMPLETE.getValue());
		return View.MENU.getName();
	}

}
