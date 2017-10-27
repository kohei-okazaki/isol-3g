package jp.co.isol.manage.service;

import java.math.BigDecimal;

import jp.co.isol.manage.dto.UserInfoDto;
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
	 * 入力情報を計算し、Dtoにつめる<br>
	 * @return
	 */
	public UserInfoDto convertUserInfo(MenuForm form, String userId);

	/**
	 * 体重差を返す<br>
	 * @param form
	 * @return
	 */
	public BigDecimal getDiffWeight(MenuForm form);


}
