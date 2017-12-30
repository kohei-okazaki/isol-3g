package jp.co.isol.manage.service;

import java.math.BigDecimal;

/**
 * 計算サービスIF
 *
 */
public interface CalcService {

	/**
	 * BMIを計算</br>
	 * @param height 身長
	 * @param weight 体重
	 * @param digit 四捨五入桁数
	 * @return BMIを計算
	 */
	public BigDecimal calcBmi(BigDecimal height, BigDecimal weight, int digit);

	/**
	 * 標準体重を計算</br>
	 * @param height 身長
	 * @param digit 四捨五入桁数
	 * @return 標準体重を計算
	 */
	public BigDecimal calcStandardWeight(BigDecimal height, int digit);

	/**
	 * 最後に入力した体重と今の体重の差を計算
	 * @param before 前の体重
	 * @param now 今の体重
	 * @return 体重の差(小数第2位を四捨五入する)
	 */
	public BigDecimal calcDiffWeight(BigDecimal before, BigDecimal now);

}
