package jp.co.isol.common.web.manage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import jp.co.isol.common.exception.BaseManageException;

/**
 * ウィザード型式の基底コントローラ<br>
 * 全てのウィザード形式コントローラクラスはこのクラスを継承すること。<br>
 * @param <F> 対象formクラス
 * @param <E> 例外クラス
 */
public interface BaseWizardController<F extends BaseForm, E extends BaseManageException> extends BaseController {

	/**
	 * Validateを設定<br>
	 * @param binder
	 */
	void initBinder(WebDataBinder binder);

	/**
	 * 入力画面
	 * @param model
	 * @param request
	 * @return
	 */
	String input(Model model, HttpServletRequest request) throws E;

	/**
	 * 確認画面
	 * @param model
	 * @param form
	 * @param result
	 * @return
	 */
	String confirm(Model model, F form, BindingResult result) throws E;

	/**
	 * 完了画面
	 * @param model
	 * @param form
	 * @param request
	 * @return
	 */
	String complete(Model model, F form, HttpServletRequest request) throws E;

}
