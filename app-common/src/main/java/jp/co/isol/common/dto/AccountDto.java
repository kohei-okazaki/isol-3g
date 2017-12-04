package jp.co.isol.common.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * アカウントのDto
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ACCOUNT")
public class AccountDto implements Serializable {

	/** シリアルバージョンUID */
	private static final Long serialVersionUID = 1L;

	/** ユーザID */
	@Id
	@Column(name = "USER_ID", nullable = false, length = 3)
	private String userId;

	/** パスワード */
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	/** 更新日時 */
	@Column(name = "UPDATE_DATE", nullable = true)
	private Date updateDate;

	/** 登録日時 */
	@Column(name = "REG_DATE", nullable = false)
	private Date regDate;

}
