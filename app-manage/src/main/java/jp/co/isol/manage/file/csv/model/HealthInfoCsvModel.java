package jp.co.isol.manage.file.csv.model;

import java.math.BigDecimal;
import java.util.Date;

import jp.co.isol.common.file.csv.annotation.Csv;
import lombok.Getter;
import lombok.Setter;

/**
 * 健康情報CSV出力モデル<br>
 * CSV出力したい項目のみ持つ
 *
 */
@Csv(headerNames = { "ユーザID", "身長", "体重", "BMI", "標準体重", "登録日時" })
public class HealthInfoCsvModel {


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

	/** 登録日時 */
	@Setter
	@Getter
	private Date regDate;

}
