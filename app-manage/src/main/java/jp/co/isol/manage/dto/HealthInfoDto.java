package jp.co.isol.manage.dto;

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
 * @author kou1210hei<br>
 * ユーザ情報を保持するDto
 */
@Entity
@Table(name = "HEALTH_INFO")
@ToString
public class HealthInfoDto implements Serializable {

	/** データID */
	@Id
	@Column(name = "DATA_ID", nullable = false, length = 3)
	@Setter
	@Getter
	private String dataId;

	/** ユーザID */
	@Column(name = "USER_ID", nullable = false, length = 3)
	@Setter
	@Getter
	private String userId;

	/** 身長 */
	@Column(name = "HEIGHT", nullable = false)
	@Setter
	@Getter
	private BigDecimal height;

	/** 体重 */
	@Column(name = "WEIGHT", nullable = false)
	@Setter
	@Getter
	private BigDecimal weight;

	/** BMI */
	@Column(name = "BMI", nullable = false)
	@Setter
	@Getter
	private BigDecimal bmi;

	/** 標準体重 */
	@Column(name = "STANDARD_WEIGHT", nullable = false)
	@Setter
	@Getter
	private BigDecimal standardWeight;

	/** ユーザステータス */
	@Column(name = "USER_STATUS", nullable = false)
	@Setter
	@Getter
	private String userStatus;

	/** 登録日時 */
	@Column(name = "REG_DATE", nullable = false)
	@Setter
	@Getter
	private Date regDate;

}
