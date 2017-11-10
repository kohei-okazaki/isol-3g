package jp.co.isol.manage.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.manage.log.ManageLogger;
import jp.co.isol.manage.service.FileDownloadService;
import jp.co.isol.manage.service.HealthInfoSearchService;
import jp.co.isol.manage.service.annotation.Reference;
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
	@Reference
	private FileDownloadService<List<HealthInfoDto>> fileDownloadService;


	/**
	 * 結果照会画面
	 * @param model
	 * @param userId
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/result-reference.html", method = RequestMethod.GET)
	public String resultReference(Model model, @SessionAttribute String userId) throws ParseException {

		ApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class);
		ManageLogger logger = context.getBean(ManageLogger.class);
		logger.info(this.getClass(), "# resultReference start");

		// ログイン中のユーザの全レコードを検索する
		model.addAttribute("allDataList", healthInfoSearchService.findHealthInfoByUserId(userId));

		return View.RESULT_REFFERNCE.getName();
	}

	/**
	 * ファイルダウンロードを実行する
	 * @param userId
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/result-reference-download.html", method = RequestMethod.GET)
	public ModelAndView excelDownload(@SessionAttribute String userId) throws ParseException {

		ApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class);
		ManageLogger logger = context.getBean(ManageLogger.class);
		logger.info(this.getClass(), "# excelDownload start");

		List<HealthInfoDto> dtoList = healthInfoSearchService.findHealthInfoByUserId(userId);
		return new ModelAndView(fileDownloadService.execute(dtoList));
	}

}
