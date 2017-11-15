package jp.co.isol.manage.csv;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

/**
 * 健康情報CSV出力モデル
 *
 */
@JsonPropertyOrder({"ユーザID", "身長", "体重", "BMI", "標準体重", "登録日"})
public class HealthInfoCsvModel {

	@JsonProperty("ユーザID")
	@Setter
	@Getter
	private String userId;

	@JsonProperty("身長")
	@Setter
	@Getter
	private BigDecimal height;

	@JsonProperty("体重")
	@Setter
	@Getter
	private BigDecimal weight;

	@JsonProperty("BMI")
	@Setter
	@Getter
	private BigDecimal bmi;

	@JsonProperty("標準体重")
	@Setter
	@Getter
	private BigDecimal standardWeight;

	@JsonProperty("登録日")
	@Setter
	@Getter
	private Date regDate;

}
