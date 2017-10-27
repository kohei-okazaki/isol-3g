package jp.co.isol.manage.service;

import java.math.BigDecimal;

/**
 * @author kou1210hei<br>
 * 計算サービスインターフェイス
 *
 */
public interface CalcService {

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

	/**
	 * 最後に入力した体重と今の体重の差を計算
	 * @param before 前の体重
	 * @param now 今の体重
	 * @return 体重の差(小数第2位を四捨五入する)
	 */
	public BigDecimal calcDiffWeight(BigDecimal before, BigDecimal now);

}

