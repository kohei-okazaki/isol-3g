package jp.co.isol.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 健康情報を保持するDto
 */
@Entity
@ToString
@Table(name = "HEALTH_INFO")
public class HealthInfoDto implements Serializable {

	/** データID */
	@Id
	@Setter
	@Getter
	@Column(name = "DATA_ID", nullable = false, length = 3)
	private String dataId;

	/** ユーザID */
	@Setter
	@Getter
	@Column(name = "USER_ID", nullable = false, length = 3)
	private String userId;

	/** 身長 */
	@Setter
	@Getter
	@Column(name = "HEIGHT", nullable = false)
	private BigDecimal height;

	/** 体重 */
	@Setter
	@Getter
	@Column(name = "WEIGHT", nullable = false)
	private BigDecimal weight;

	/** BMI */
	@Setter
	@Getter
	@Column(name = "BMI", nullable = false)
	private BigDecimal bmi;

	/** 標準体重 */
	@Setter
	@Getter
	@Column(name = "STANDARD_WEIGHT", nullable = false)
	private BigDecimal standardWeight;

	/** ユーザステータス */
	@Setter
	@Getter
	@Column(name = "USER_STATUS", nullable = false)
	private String userStatus;

	/** 登録日時 */
	@Setter
	@Getter
	@Column(name = "REG_DATE", nullable = false)
	private Date regDate;

}
