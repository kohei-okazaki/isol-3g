package jp.co.isol.manage.service;

import java.math.BigDecimal;

import jp.co.isol.common.message.Message;
import jp.co.isol.manage.dto.HealthInfoDto;
import jp.co.isol.manage.form.HealthInfoInputForm;

/**
 * @author kou1210hei<br>
 * メニュー画面のサービスインターフェイス
 *
 */
public interface MenuService {

	/**
	 * 入力した体重と最後に入力した体重との差を表示する<br>
	 * @param form
	 * @param dto
	 * @return 体重差のメッセージ
	 */
	public Message getDiffMessage(HealthInfoInputForm form, HealthInfoDto dto);

	/**
	 * 入力情報を計算し、Dtoにつめる<br>
	 * @return
	 */
	public HealthInfoDto convertUserInfo(HealthInfoInputForm form, String userId);

	/**
	 * 最後に入力した体重とフォームから体重差を返却
	 * @param form
	 * @param dto
	 * @return 体重差
	 */
	public BigDecimal getDiffWeight(HealthInfoInputForm form, HealthInfoDto dto);


}
