package jp.co.isol.manage.service;

import java.math.BigDecimal;

import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.common.entity.HealthInfo;
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
	 * @param lastHealthInfo
	 * @return
	 */
	public HealthInfoDto convertHealthInfoDto(HealthInfoForm form, String userId, HealthInfo lastHealthInfo);

	/**
	 * 入力した体重と最後に入力した体重との差からメッセージを返す<br>
	 * @param form
	 * @param lastHealthInfo
	 * @return 体重差のメッセージ
	 */
	public String getDiffMessage(HealthInfoForm form, HealthInfo lastHealthInfo);

	/**
	 * 最後に入力した体重とフォームから体重差を返却
	 * @param form
	 * @param lastHealthInfo
	 * @return 体重差
	 */
	public BigDecimal getDiffWeight(HealthInfoForm form, HealthInfo lastHealthInfo);

	/**
	 * 健康情報Dtoを健康情報Entityにつめる<br>
	 * @param dto
	 * @return
	 */
	public HealthInfo convertHealthInfo(HealthInfoDto dto);

}
