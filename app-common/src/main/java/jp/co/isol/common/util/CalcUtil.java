package jp.co.isol.common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import jp.co.isol.common.other.CalcMethod;

/**
 * 計算処理のUtilクラス<br>
 * インスタンス生成を制限<br>
 *
 */
public class CalcUtil {

	private CalcUtil() {
	}

	/** マイナス */
	public static final String MINUS = "-";

	/**
	 * 四則演算を行う<br>
	 * ex) target1 = 100, method = CalcMethod.SUBTRACT, target2 = 30, result = 70<br>
	 * @param target1
	 * @param method
	 * @param target2
	 * @param degit
	 * @param roudingMode
	 * @return
	 */
	public static BigDecimal execute(BigDecimal target1, CalcMethod method, BigDecimal target2, int degit, RoundingMode roudingMode) {
		return method.getOperator().apply(target1, target2, degit, roudingMode);
	}


//	/**
//	 * 単位を以下に変換する</br>
//	 * cm → m
//	 * @param target 対象の値
//	 * @return メートル
//	 */
//	public static BigDecimal convertMeterFromCentiMeter(BigDecimal target) {
//		return target.scaleByPowerOfTen(-2);
//	}

//	/**
//	 * 単位を以下に変換する</br>
//	 * m → cm
//	 * @param target 対象の値
//	 * @return センチメートル
//	 */
//	public static BigDecimal convertCentiMeterFromMeter(BigDecimal target) {
//		return target.scaleByPowerOfTen(2);
//	}

//	/**
//	 * BMIを計算</br>
//	 * @param height 身長
//	 * @param weight 体重
//	 * @param digit 四捨五入桁数
//	 * @return BMIを計算
//	 */
//	public static BigDecimal calcBmi(BigDecimal height, BigDecimal weight, int digit) {
//		return weight.divide(height.multiply(height), digit, RoundingMode.HALF_UP);
//	}

//	/**
//	 * 標準体重を計算</br>
//	 * @param height 身長
//	 * @param digit 四捨五入桁数
//	 * @return 標準体重を計算
//	 */
//	public static BigDecimal calcStandardWeight(BigDecimal height, int digit) {
//		return height.multiply(height).multiply(new BigDecimal(22)).setScale(digit, RoundingMode.HALF_UP);
//	}

}
