package jp.co.isol.manage.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import jp.co.isol.manage.form.BaseForm;

/**
 * ウィザード型式の基底コントローラ<br>
 * @param F form
 *
 */
public abstract class BaseWizardController<F extends BaseForm> {

	/**
	 * 入力画面
	 * @param model
	 * @param request
	 * @return
	 */
	public abstract String input(Model model, HttpServletRequest request);

	/**
	 * 確認画面
	 * @param model
	 * @param form
	 * @return
	 */
	public abstract String confirm(Model model, F form);

	/**
	 * 完了画面
	 * @param model
	 * @param form
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	public abstract String complete(Model model, F form, HttpServletRequest request) throws ParseException;

}
