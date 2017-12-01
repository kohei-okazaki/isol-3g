package jp.co.isol.common.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * メール情報Dto<br>
 * ユーザのメール情報を持つDtoクラス<br>
 *
 */
@Entity
@Table(name = "MAIL_INFO")
@ToString(exclude = "mailPassword")
public class MailInfoDto {

	/** ユーザID */
	@Id
	@Setter
	@Getter
	@Column(name = "USER_ID", nullable = false, length = 3)
	private String userId;

	/** メールアドレス */
	@Setter
	@Getter
	@Column(name = "MAIL_ADDRESS", nullable = false)
	private String mailAddress;

	/** メールパスワード */
	@Setter
	@Getter
	@Column(name = "MAIL_PASSWORD", nullable = false)
	private String mailPassword;

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
