package jp.co.isol.manage.controller;

import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.isol.common.util.DateUtil;
import jp.co.isol.manage.dao.UserInfoDao;
import jp.co.isol.manage.form.MenuForm;
import jp.co.isol.manage.service.MenuService;
import jp.co.isol.manage.service.UserInfoSearchService;
import jp.co.isol.manage.view.View;

/**
 * 健康管理_メニュー画面コントローラ
 *
 */
@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;
	@Autowired
	private UserInfoSearchService userInfoSearchService;
	@Autowired
	private UserInfoDao userInfoDao;

	private static final Logger LOG = LoggerFactory.getLogger(MenuController.class.getSimpleName());

	/**
	 * メニュー画面
	 * @param locale
	 * @param model
	 * @param form
	 * @return View
	 */
	@RequestMapping(value = "/menu.html", method = RequestMethod.POST)
	public String menu(Locale locale, Model model, MenuForm form) {

		LOG.info("---> MenuController start");

		// 時刻取得
		model.addAttribute("serverTime", DateUtil.getFormattedTime(locale));

		// Daoから前回の体重を取得
		model.addAttribute("beforeWeight", userInfoSearchService.getUserInfoEntity("1").getWeight());

		// 入力情報.体重を取得
		model.addAttribute("inputWeight", form.getWeight());

		// 入力情報.身長を取得
		model.addAttribute("inputHeight", form.getHeight());

		// 入力情報.身長から標準体重を計算
		model.addAttribute("standardWeight", menuService.getStandardWeight(form));

		// 「入力情報.身長」と「入力情報.体重」からBMIを計算
		model.addAttribute("bmi", menuService.getBmi(form));

		// 入力した今の体重と前回入力した体重の差を設定
		model.addAttribute("diffWeight", menuService.getDiffWeight(form));

		// 「入力情報.体重」と前回入力した体重の結果からメッセージを設定
		model.addAttribute("resultMessage", menuService.getDiffMessage(form));

		// 入力画面から入力した情報を登録する
		userInfoDao.registUserUnfo(form);

		return View.MENU.getName();

	}

	/**
	 * エクセルをダウンロードする<br>
	 * @param model
	 * @param form
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/menu/fileDownload.html", method = RequestMethod.GET)
	public ModelAndView excelDownload(Map<String, Object> model, MenuForm form) {

		LOG.info("-----> excel file download start");

		return new ModelAndView(menuService.fileDownload(form));

	}

}