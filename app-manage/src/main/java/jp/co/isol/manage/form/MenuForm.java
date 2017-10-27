package jp.co.isol.manage.form;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

/**
 * @kou1210hei<br>
 * 入力フォームクラス
 *
 */
public class MenuForm implements Serializable {

	/** ユーザID */
	@Column(name = "USER_ID", nullable = false, length = 3)
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
