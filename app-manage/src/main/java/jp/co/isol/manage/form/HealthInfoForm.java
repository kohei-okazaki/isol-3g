package jp.co.isol.manage.form;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 * 健康情報フォームクラス
 *
 */
public class HealthInfoForm implements Serializable {

	/** ユーザID */
	@Setter
	@Getter
	private String userId;

	/** 身長 */
	@Setter
	@Getter
	private BigDecimal height;

	/** 体重 */
	@Setter
	@Getter
	private BigDecimal weight;

	/** BMI */
	@Setter
	@Getter
	private BigDecimal bmi;

	/** 標準体重 */
	@Setter
	@Getter
	private BigDecimal standardWeight;

}
