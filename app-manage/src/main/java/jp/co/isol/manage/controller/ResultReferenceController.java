package jp.co.isol.manage.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.isol.common.util.DateUtil;
import jp.co.isol.manage.service.UserInfoSearchService;
import jp.co.isol.manage.view.View;


@Controller
public class ResultReferenceController {

	@Autowired
	private UserInfoSearchService userInfoSearchService;

	private static final Logger LOG = LoggerFactory.getLogger(ResultReferenceController.class.getSimpleName());

	@RequestMapping(value = "/menu/result-reference.html", method = RequestMethod.POST)
	public String resultReference(Locale locale, Model model) {

		LOG.info("-----> refernceController start");
		// 時刻取得
		model.addAttribute("serverTime", DateUtil.getFormattedTime(locale));

		// 全ユーザ情報を取得する
		model.addAttribute("allDataList", userInfoSearchService.getUserAllData());

		return View.RESULT_REFFERNCE.getName();
	}

}
