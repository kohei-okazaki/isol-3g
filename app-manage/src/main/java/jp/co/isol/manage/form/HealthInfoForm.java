package jp.co.isol.manage.form;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * 健康情報フォームクラス
 *
 */
@Data
public class HealthInfoForm implements Serializable {

	/** ユーザID */
	@Max(10)
	@NotBlank
	private String userId;

	/** 身長 */
	@NotBlank
	@DecimalMax("10")
	private BigDecimal height;

	/** 体重 */
	@NotBlank
	@DecimalMax("10")
	private BigDecimal weight;

	/** BMI */
	@DecimalMax("10")
	private BigDecimal bmi;

	/** 標準体重 */
	@DecimalMax("10")
	private BigDecimal standardWeight;

}
