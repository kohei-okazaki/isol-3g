package jp.co.isol.web.service;

import java.math.BigDecimal;

import jp.co.isol.common.entity.HealthInfo;
import jp.co.isol.web.form.HealthInfoForm;

/**
 * 健康情報サービスインターフェース<br>
 *
 */
public interface HealthInfoService {

	/**
	 * 入力した体重と最後に入力した体重との差からメッセージを返す<br>
	 * @param form
	 * @param lastHealthInfo
	 * @return 体重差のメッセージ
	 */
	String getDiffMessage(HealthInfoForm form, HealthInfo lastHealthInfo);

	/**
	 * 最後に入力した体重とフォームから体重差を返却
	 * @param form
	 * @param lastHealthInfo
	 * @return 体重差
	 */
	BigDecimal getDiffWeight(HealthInfoForm form, HealthInfo lastHealthInfo);

	/**
	 * 健康情報formを健康情報Entityにつめる<br>
	 * @param form
	 * @param userId
	 * @param lastHealthInfo
	 * @return
	 */
	HealthInfo convertHealthInfo(HealthInfoForm form, String userId, HealthInfo lastHealthInfo);

}
