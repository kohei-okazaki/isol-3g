package jp.co.isol.common.other;

import java.math.BigDecimal;
import java.util.function.BinaryOperator;

/**
 * 四則演算メソッド定義<br>
 *
 */
public enum CalcMethod {

	/** 和 */
	ADD((num1, num2) -> num1.add(num2)),
	/** 差 */
	SUBTRACT((num1, num2) -> num1.subtract(num2)),
	/** 積 */
	MULTIPLY((num1, num2) -> num1.multiply(num2)),
	/** 商 */
	DIVIDE((num1, num2) -> num1.divide(num2));

	private BinaryOperator<BigDecimal> option;

	private CalcMethod(BinaryOperator<BigDecimal> option) {
		this.option = option;
	}

	/**
	 * 四則演算関数を返す<br>
	 * @return
	 */
	public BinaryOperator<BigDecimal> getOption() {
		return option;
	}
}
