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
import jp.co.isol.manage.form.MenuForm;
import jp.co.isol.manage.log.AppLogger;
import jp.co.isol.manage.service.FileDownloadService;
import jp.co.isol.manage.service.MenuService;
import jp.co.isol.manage.service.UserInfoSearchService;
import jp.co.isol.manage.service.annotation.Menu;
import jp.co.isol.manage.view.View;
import jp.co.isol.manage.web.config.AppConfig;
import jp.co.isol.manage.web.session.AppSessionKey;
import jp.co.isol.manage.web.session.AppSessionManager;

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
	@Autowired
	@Menu
	private FileDownloadService<MenuForm> fileDownloadService;

	/**
	 * メニュー画面
	 * @param locale
	 * @param model
	 * @param form
	 * @return View
	 * @throws ParseException
	 */
	@RequestMapping(value = "/menu.html", method = RequestMethod.POST)
	public String menu(Model model, MenuForm form, HttpServletRequest request) throws ParseException {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppLogger logger = context.getBean(AppLogger.class);
		logger.info(this.getClass(), "# menu start");


		AppSessionManager manager = context.getBean(AppSessionManager.class);
		String userId = manager.getAttribute(request.getSession(), AppSessionKey.USER_ID);
		UserInfoDto dto = menuService.convertUserInfo(form, userId);

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
		model.addAttribute("diffWeight", menuService.getDiffWeight(form, lastDto));

		// 「入力情報.体重」と前回入力した体重の結果からメッセージを設定
		model.addAttribute("resultMessage", menuService.getDiffMessage(form, lastDto).getName());

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

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppLogger logger = context.getBean(AppLogger.class);
		logger.info(this.getClass(), "# menu start");

		return new ModelAndView(fileDownloadService.execute(form));

	}

	/**
	 * getでメニュー画面に遷移する<br>
	 * @param locale
	 * @param model
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/menu.html", method = RequestMethod.GET)
	public String menu() {
		return View.MENU.getName();
	}

}