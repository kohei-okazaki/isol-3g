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
	@Column(name = "USER_ID", nullable = false, length = 3)
	@Setter
	@Getter
	private String userId;

	/** メールアドレス */
	@Column(name = "MAIL_ADDRESS", nullable = false)
	@Setter
	@Getter
	private String mailAddress;

	/** メールパスワード */
	@Column(name = "MAIL_PASSWORD", nullable = false)
	@Setter
	@Getter
	private String mailPassword;

	/** 更新日時 */
	@Column(name = "UPDATE_DATE", nullable = true)
	@Setter
	@Getter
	private Date updateDate;

	/** 登録日時 */
	@Column(name = "REG_DATE", nullable = false)
	@Setter
	@Getter
	private Date regDate;

}
