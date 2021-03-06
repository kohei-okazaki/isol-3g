package jp.co.isol.common.other;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 四則演算オペレータインターフェース<br>
 *
 */
@FunctionalInterface
public interface CalcOperator {

	/**
	 * 四則演算を定義<br>
	 * @param target1
	 * @param target2
	 * @param degit
	 * @param rougingMode
	 * @return
	 */
	public BigDecimal apply(BigDecimal target1, BigDecimal target2, int degit, RoundingMode rougingMode);
}
