package jp.co.isol.common.util;

import java.math.BigDecimal;

public class CalcUtil {

	/**
	 * インスタンス生成を制限
	 */
	private CalcUtil() {
	}

	/**
	 * 単位を以下に変換する</br>
	 * cm → m
	 * @param target
	 * @return メートル
	 */
	public static BigDecimal convertMeter(BigDecimal target) {
		double value = target.doubleValue();
		value = value / 100;
		return new BigDecimal(value);
	}

	/**
	 * 単位を以下に変換する</br>
	 * m → cm
	 * @param target
	 * @return センチメートル
	 */
	public static BigDecimal convertCentiMeter(BigDecimal target) {
		double value = target.doubleValue();
		value = value / 100;
		return new BigDecimal(value);
	}

}
