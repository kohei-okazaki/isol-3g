package jp.co.isol.api.service;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import jp.co.isol.api.dto.HealthInfoDto;

/**
 * @author kou1210hei<br>
 * 健康情報サービスIF<br>
 *
 */
public interface HealthInfoService {

	/**
	 * 健康情報DTOにrequestの内容をつめる<br>
	 * @param dto
	 * @param request
	 */
	public HealthInfoDto execute(HealthInfoDto dto, HttpServletRequest request);

	/**
	 * BMIを計算(小数第2位を四捨五入する)
	 * @param height
	 * @param weight
	 * @return BMIを計算(小数第2位を四捨五入する)
	 */
	public BigDecimal calcBmi(BigDecimal height, BigDecimal weight);

	/**
	 * 標準体重を計算(小数第2位を四捨五入する)
	 * @param height
	 * @return 標準体重を計算(小数第2位を四捨五入する)
	 */
	public BigDecimal calcStandardWeight(BigDecimal height);
}
