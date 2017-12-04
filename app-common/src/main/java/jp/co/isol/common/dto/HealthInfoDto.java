package jp.co.isol.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 健康情報を保持するDto
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HEALTH_INFO")
public class HealthInfoDto implements Serializable {

	private static final Long serialVersionUID = 1L;

	/** データID */
	@Id
	@Column(name = "DATA_ID", nullable = false, length = 3)
	private String dataId;

	/** ユーザID */
	@Column(name = "USER_ID", nullable = false, length = 3)
	private String userId;

	/** 身長 */
	@Column(name = "HEIGHT", nullable = false)
	private BigDecimal height;

	/** 体重 */
	@Column(name = "WEIGHT", nullable = false)
	private BigDecimal weight;

	/** BMI */
	@Column(name = "BMI", nullable = false)
	private BigDecimal bmi;

	/** 標準体重 */
	@Column(name = "STANDARD_WEIGHT", nullable = false)
	private BigDecimal standardWeight;

	/** ユーザステータス */
	@Column(name = "USER_STATUS", nullable = false)
	private String userStatus;

	/** 登録日時 */
	@Column(name = "REG_DATE", nullable = false)
	private Date regDate;

}
