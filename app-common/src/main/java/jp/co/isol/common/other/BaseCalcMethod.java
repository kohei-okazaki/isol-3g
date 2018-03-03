package jp.co.isol.common.other;

import java.math.BigDecimal;
import java.util.function.BinaryOperator;

/**
 * 基本四則演算メソッド定義<br>
 *
 */
public enum BaseCalcMethod {

	/** 和 */
	ADD((num1, num2) -> num1.subtract(num2)),
	/** 差 */
	SUBTRACT((num1, num2) -> num1.subtract(num2)),
	/** 積 */
	MULTIPLY((num1, num2) -> num1.multiply(num2)),
	/** 商 */
	DIVIDE((num1, num2) -> num1.divide(num2));

	private BinaryOperator<BigDecimal> operator;

	private BaseCalcMethod(BinaryOperator<BigDecimal> operator) {
		this.operator = operator;
	}

	public BinaryOperator<BigDecimal> getOperator() {
		return this.operator;
	}
}
