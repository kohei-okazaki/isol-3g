package jp.co.isol.common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author kou1210hei<br>
 * 計算処理のUtilクラス
 *
 */
public class CalcUtil {

	public static final String MINUS = "-";

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
	public static BigDecimal convertMeterFromCentiMeter(BigDecimal target) {
		return target.divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
	}

	/**
	 * 単位を以下に変換する</br>
	 * m → cm
	 * @param target
	 * @return センチメートル
	 */
	public static BigDecimal convertCentiMeterFromMeter(BigDecimal target) {
		return target.multiply(new BigDecimal("100"));
	}

}
