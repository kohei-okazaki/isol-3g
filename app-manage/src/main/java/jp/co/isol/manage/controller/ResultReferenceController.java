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

import jp.co.isol.manage.dto.HealthInfoDto;
import jp.co.isol.manage.log.AppLogger;
import jp.co.isol.manage.service.FileDownloadService;
import jp.co.isol.manage.service.HealthInfoSearchService;
import jp.co.isol.manage.service.annotation.Reference;
import jp.co.isol.manage.view.View;
import jp.co.isol.manage.web.config.AppConfig;

/**
 * @author kou1210hei<br>
 * 健康管理_結果照会画面コントローラクラス<br>
 *
 */
@Controller
public class ResultReferenceController {

	/** ユーザ情報検索サービス */
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

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppLogger logger = context.getBean(AppLogger.class);
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

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppLogger logger = context.getBean(AppLogger.class);
		logger.info(this.getClass(), "# excelDownload start");

		return new ModelAndView(fileDownloadService.execute(healthInfoSearchService.findHealthInfoByUserId(userId)));
	}

}
