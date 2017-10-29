package jp.co.isol.manage.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.isol.manage.dao.UserInfoDao;
import jp.co.isol.manage.dto.UserInfoDto;
import jp.co.isol.manage.form.UserInfoInputForm;
import jp.co.isol.manage.log.AppLogger;
import jp.co.isol.manage.service.FileDownloadService;
import jp.co.isol.manage.service.InputService;
import jp.co.isol.manage.service.UserInfoSearchService;
import jp.co.isol.manage.service.annotation.UserInfoInput;
import jp.co.isol.manage.view.PageView;
import jp.co.isol.manage.view.View;
import jp.co.isol.manage.web.config.AppConfig;
import jp.co.isol.manage.web.session.AppSessionKey;
import jp.co.isol.manage.web.session.AppSessionManager;

/**
 * 健康管理_入力画面コントローラ
 *
 */
@Controller
public class InputController {

	@Autowired
	private InputService inputService;
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private UserInfoSearchService userInfoSearchService;
	@Autowired
	@UserInfoInput
	private FileDownloadService<UserInfoInputForm> fileDownloadService;

	/**
	 * 入力画面
	 * @param locale
	 * @param model
	 * @param loginForm
	 * @param request
	 * @return 遷移先を返却
	 */
	@RequestMapping(value = "/input.html", method = RequestMethod.GET)
	public String input(Model model) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppLogger logger = context.getBean(AppLogger.class);
		logger.info(this.getClass(), "#input start");

		model.addAttribute("page", PageView.INPUT.getValue());

		return View.INPUT.getName();
	}

	/**
	 * 確認画面
	 * @param locale
	 * @param model
	 * @param form
	 * @return 確認画面
	 */
	@RequestMapping(value = "/input-confirm.html", method = RequestMethod.POST)
	public String confirm(Model model, UserInfoInputForm form) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppLogger logger = context.getBean(AppLogger.class);
		logger.info(this.getClass(), "#confirm start");

		if (inputService.hasError(form)) {
			// 入力情報に誤りがある場合
			logger.warn(this.getClass(), "入力情報に誤りがあります");
			return View.ERROR.getName();
		}

		// 入力情報を設定
		model.addAttribute("form", form);

		model.addAttribute("page", PageView.CONFIRM.getValue());

		return View.INPUT.getName();
	}

	/**
	 * 完了画面
	 * @param model
	 * @param form
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/input-complete.html", method = RequestMethod.POST)
	public String complete(Model model, UserInfoInputForm form, HttpServletRequest request) throws ParseException {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppLogger logger = context.getBean(AppLogger.class);
		logger.info(this.getClass(), "# menu complete");

		AppSessionManager manager = context.getBean(AppSessionManager.class);
		String userId = manager.getAttribute(request.getSession(), AppSessionKey.USER_ID);

		UserInfoDto dto = inputService.convertUserInfo(form, userId);

		// 入力画面から入力した情報を登録する
		userInfoDao.registUserUnfo(dto);

		// Daoから前回の体重を取得
		List<UserInfoDto> dtoList = userInfoSearchService.findUserInfoByUserId(userId);

		int lastIndex = dtoList.size() - 1;
		UserInfoDto lastDto = dtoList.get(lastIndex);
		model.addAttribute("beforeWeight", lastDto.getWeight());

		// Dtoを設定する
		model.addAttribute("dto", dto);

		// 入力した今の体重と前回入力した体重の差を設定
		model.addAttribute("diffWeight", inputService.getDiffWeight(form, lastDto));

		// 「入力情報.体重」と前回入力した体重の結果からメッセージを設定
		model.addAttribute("resultMessage", inputService.getDiffMessage(form, lastDto).getName());

		model.addAttribute("page", PageView.COMPLETE.getValue());
		return View.INPUT.getName();
	}


	/**
	 * エクセルをダウンロードする<br>
	 * @param model
	 * @param form
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/fileDownload.html", method = RequestMethod.GET)
	public ModelAndView excelDownload(Map<String, Object> model, UserInfoInputForm form) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppLogger logger = context.getBean(AppLogger.class);
		logger.info(this.getClass(), "# excelDownload start");

		return new ModelAndView(fileDownloadService.execute(form));

	}

}
