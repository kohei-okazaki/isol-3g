package jp.co.isol.common.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * アカウントのDto
 *
 */
@Entity
@Table(name = "ACCOUNT")
@ToString(exclude = "password")
public class AccountDto implements Serializable {

	/** ユーザID */
	@Id
	@Setter
	@Getter
	@Column(name = "USER_ID", nullable = false, length = 3)
	private String userId;

	/** パスワード */
	@Setter
	@Getter
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	/** 更新日時 */
	@Setter
	@Getter
	@Column(name = "UPDATE_DATE", nullable = true)
	private Date updateDate;

	/** 登録日時 */
	@Setter
	@Getter
	@Column(name = "REG_DATE", nullable = false)
	private Date regDate;

}
