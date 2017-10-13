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
 * ユーザ情報を保持するentity
 */
@Entity
@Table(name = "USER_INFO")
@ToString
public class UserInfoDto implements Serializable {

	// ID
	@Id
	@Column(name = "ID", nullable = false, length = 3)
	@Setter
	@Getter
	private String id;

	// 身長
	@Column(name = "HEIGHT", nullable = false)
	@Setter
	@Getter
	private BigDecimal height;

	// 体重
	@Column(name = "WEIGHT", nullable = false)
	@Setter
	@Getter
	private BigDecimal weight;

	// BMI
	@Column(name = "BMI", nullable = false)
	@Setter
	@Getter
	private BigDecimal bmi;

	// 標準体重
	@Column(name = "STANDARD_WEIGHT", nullable = false)
	@Setter
	@Getter
	private BigDecimal standardWeight;

	// 登録日時
	@Column(name = "RECORD_DATE", nullable = false)
	@Setter
	@Getter
	private Date recordDate;

}
