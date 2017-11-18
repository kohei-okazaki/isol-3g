package jp.co.isol.manage.form;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * 健康情報フォームクラス
 *
 */
@Data
public class HealthInfoForm implements Serializable {

	/** ユーザID */
	private String userId;

	/** 身長 */
	private BigDecimal height;

	/** 体重 */
	private BigDecimal weight;

	/** BMI */
	private BigDecimal bmi;

	/** 標準体重 */
	private BigDecimal standardWeight;

}
