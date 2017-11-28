package jp.co.isol.manage.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.manage.log.ManageLogger;
import jp.co.isol.manage.service.ExcelDownloadService;
import jp.co.isol.manage.service.HealthInfoSearchService;
import jp.co.isol.manage.service.annotation.ReferenceExcel;
import jp.co.isol.manage.view.View;
import jp.co.isol.manage.web.config.ManageConfig;

/**
 * 健康管理_健康情報結果照会画面コントローラクラス<br>
 *
 */
@Controller
public class ResultReferenceController {

	/** 健康情報検索サービス */
	@Autowired
	private HealthInfoSearchService healthInfoSearchService;

	/** ファイルダウンロードサービス */
	@Autowired
	@ReferenceExcel
	private ExcelDownloadService<List<HealthInfoDto>> fileDownloadService;


	/**
	 * 結果照会画面
	 * @param model
	 * @param userId
	 * @return
	 * @throws ParseException
	 */
	@GetMapping
	@RequestMapping(value = "/result-reference.html")
	public String resultReference(Model model, @SessionAttribute String userId) throws ParseException {

		ManageLogger logger;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			logger = context.getBean(ManageLogger.class);
		}
		logger.info(this.getClass(), "# resultReference start");

		// ログイン中のユーザの全レコードを検索する
		model.addAttribute("resultList", healthInfoSearchService.findHealthInfoByUserId(userId));

		return View.RESULT_REFFERNCE.getName();
	}

	/**
	 * ファイルダウンロードを実行する
	 * @param userId
	 * @return
	 * @throws ParseException
	 */
	@GetMapping
	@RequestMapping(value = "/result-reference-excelDownload.html")
	public ModelAndView excelDownload(@SessionAttribute String userId) throws ParseException {

		ManageLogger logger;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			logger = context.getBean(ManageLogger.class);
		}
		logger.info(this.getClass(), "# excelDownload start");

		List<HealthInfoDto> dtoList = healthInfoSearchService.findHealthInfoByUserId(userId);
		return new ModelAndView(fileDownloadService.execute(dtoList));
	}

}
