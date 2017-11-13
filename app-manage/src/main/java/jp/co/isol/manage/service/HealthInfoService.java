package jp.co.isol.manage.service;

import java.math.BigDecimal;
import java.util.Objects;

import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.manage.form.HealthInfoForm;

/**
 * 健康情報入力サービスIF
 *
 */
public interface HealthInfoService {

	/**
	 * 入力情報のチェック
	 * @param form
	 * @return 判定結果
	 */
	public boolean hasError(HealthInfoForm form);

	/**
	 * マイナスが含まれていた場合true
	 * 引き数はnullではないものとする
	 * @param target1
	 * @param target2
	 * @return 判定結果
	 */
	public default boolean hasContainMinus(BigDecimal target1, BigDecimal target2) {
		return target1.toString().contains("-") || target2.toString().contains("-");

	}

	/**
	 * nullが含まれていた場合true
	 * @param target1
	 * @param target2
	 * @return 判定結果
	 */
	public default boolean hasNull(BigDecimal target1, BigDecimal target2) {
		return Objects.isNull(target1) || Objects.isNull(target2);
	}

	/**
	 * 入力情報をDtoにつめる<br>
	 * @return
	 */
	public HealthInfoDto convertUserInfo(HealthInfoForm form, String userId);

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
