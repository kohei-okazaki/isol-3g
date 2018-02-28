package jp.co.isol.common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import jp.co.isol.common.other.CalcMethod;

/**
 * 健康情報Utilクラス<br>
 *
 */
public class HealthInfoUtil {

	private HealthInfoUtil() {
	}

	/**
	 * 単位を以下に変換する</br>
	 * cm → m
	 * @param target 対象の値
	 * @return メートル
	 */
	public static BigDecimal convertMeterFromCentiMeter(BigDecimal target) {
		return target.scaleByPowerOfTen(-2);
	}

	/**
	 * 単位を以下に変換する</br>
	 * m → cm
	 * @param target 対象の値
	 * @return センチメートル
	 */
	public static BigDecimal convertCentiMeterFromMeter(BigDecimal target) {
		return target.scaleByPowerOfTen(2);
	}

	/**
	 * BMIを計算</br>
	 * @param height 身長
	 * @param weight 体重
	 * @param digit 四捨五入桁数
	 * @return BMIを計算
	 */
	public static BigDecimal calcBmi(BigDecimal height, BigDecimal weight, int digit) {
		BigDecimal multiplyResult = CalcUtil.execute(height, CalcMethod.MULTIPLY, weight);
		BigDecimal result = CalcUtil.execute(weight, CalcMethod.DIVIDE, multiplyResult);
		result = result.setScale(digit, RoundingMode.HALF_UP);

		// 修正前
		BigDecimal bef = weight.divide(height.multiply(height), digit, RoundingMode.HALF_UP);
		return result;
	}

	/**
	 * 標準体重を計算</br>
	 * @param height 身長
	 * @param digit 四捨五入桁数
	 * @return 標準体重を計算
	 */
	public static BigDecimal calcStandardWeight(BigDecimal height, int digit) {
		return height.multiply(height).multiply(new BigDecimal(22)).setScale(digit, RoundingMode.HALF_UP);
	}
}
