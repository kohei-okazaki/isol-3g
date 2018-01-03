package jp.co.isol.common.web.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import jp.co.isol.common.exception.BaseMvcException;

/**
 * ウィザード型式の基底コントローラ<br>
 *
 * @param <F> 対象formクラス
 * @param <E> 例外クラス
 */
public abstract class BaseWizardController<F extends BaseForm, E extends BaseMvcException> {

	/**
	 * Validateを設定<br>
	 * @param binder
	 */
	public abstract void initBinder(WebDataBinder binder);

	/**
	 * 入力画面
	 * @param model
	 * @param request
	 * @return
	 */
	public abstract String input(Model model, HttpServletRequest request) throws E;

	/**
	 * 確認画面
	 * @param model
	 * @param form
	 * @param result
	 * @return
	 */
	public abstract String confirm(Model model, F form, BindingResult result) throws E;

	/**
	 * 完了画面
	 * @param model
	 * @param form
	 * @param request
	 * @return
	 */
	public abstract String complete(Model model, F form, HttpServletRequest request) throws E;

}
