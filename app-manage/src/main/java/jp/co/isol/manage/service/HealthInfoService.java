package jp.co.isol.manage.service;

import java.math.BigDecimal;

import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.manage.form.HealthInfoForm;

/**
 * 健康情報サービスインターフェース<br>
 *
 */
public interface HealthInfoService {

	/**
	 * 入力情報をDtoにつめる<br>
	 * @param form
	 * @param userId
	 * @return
	 */
	public HealthInfoDto convertHealthInfoDto(HealthInfoForm form, String userId);

	/**
	 * 入力した体重と最後に入力した体重との差を表示する<br>
	 * @param form
	 * @param dto
	 * @return 体重差のメッセージ
	 */
	public String getDiffMessage(HealthInfoForm form, HealthInfoDto dto);

	/**
	 * 最後に入力した体重とフォームから体重差を返却
	 * @param form
	 * @param dto
	 * @return 体重差
	 */
	public BigDecimal getDiffWeight(HealthInfoForm form, HealthInfoDto dto);

}
