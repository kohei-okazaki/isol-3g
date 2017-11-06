package jp.co.isol.api.service;

import java.math.BigDecimal;

public interface HealthInfoService {

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
