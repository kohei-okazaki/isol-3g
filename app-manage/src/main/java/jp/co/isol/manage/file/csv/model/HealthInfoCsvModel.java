package jp.co.isol.manage.file.csv.model;

import java.math.BigDecimal;
import java.util.Date;

import jp.co.isol.common.file.csv.annotation.Csv;
import lombok.Getter;
import lombok.Setter;

/**
 * 健康情報CSV出力モデル
 *
 */
@Csv(headerNames = { "ユーザID", "身長", "体重", "BMI", "標準体重", "登録日時" })
public class HealthInfoCsvModel {

	@Setter
	@Getter
	private String userId;

	@Setter
	@Getter
	private BigDecimal height;

	@Setter
	@Getter
	private BigDecimal weight;

	@Setter
	@Getter
	private BigDecimal bmi;

	@Setter
	@Getter
	private BigDecimal standardWeight;

	@Setter
	@Getter
	private Date regDate;

}
