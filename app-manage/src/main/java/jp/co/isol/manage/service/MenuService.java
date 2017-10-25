package jp.co.isol.manage.service;

import jp.co.isol.manage.form.MenuForm;

/**
 * @author kou1210hei<br>
 * メニュー画面のサービスインターフェイス
 *
 */
public interface MenuService {

	/**
	 * 入力した体重と最後に入力した体重との差を表示する<br>
	 * @param form
	 * @return 体重差のメッセージ
	 */
	public String getDiffMessage(MenuForm form);

	/**
	 * フォームから標準体重を返却<br>
	 * @param form
	 * @return 標準体重
	 */
	public double getStandardWeight(MenuForm form);

	/**
	 * フォームからBMIを返却<br>
	 * @param form
	 * @return BMI
	 */
	public double getBmi(MenuForm form);

	/**
	 * フォームから体重差を返却
	 * @param form
	 * @return 体重差
	 */
	public double getDiffWeight(MenuForm form);


}
