package jp.co.isol.manage.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.isol.common.util.DateUtil;
import jp.co.isol.manage.log.AppLogger;
import jp.co.isol.manage.service.UserInfoSearchService;
import jp.co.isol.manage.view.View;
import jp.co.isol.manage.web.config.AppConfig;


/**
 * @author kou1210hei<br>
 * 結果照会画面コントローラクラス<br>
 *
 */
@Controller
public class ResultReferenceController {

	@Autowired
	private UserInfoSearchService userInfoSearchService;


	@RequestMapping(value = "/menu/result-reference.html", method = RequestMethod.POST)
	public String resultReference(Locale locale, Model model) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppLogger logger = context.getBean(AppLogger.class);
		logger.info(this.getClass(), "# resultReference start");

		// 時刻取得
		model.addAttribute("serverTime", DateUtil.getFormattedTime(locale));

		// 全ユーザ情報を取得する
		model.addAttribute("allDataList", userInfoSearchService.getUserAllData());

		return View.RESULT_REFFERNCE.getName();
	}

}
