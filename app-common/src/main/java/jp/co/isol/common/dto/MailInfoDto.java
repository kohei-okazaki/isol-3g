package jp.co.isol.common.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * メール情報Dto<br>
 * ユーザのメール情報を持つDtoクラス<br>
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MAIL_INFO")
public class MailInfoDto {

	/** ユーザID */
	@Id
	@Column(name = "USER_ID", nullable = false, length = 3)
	private String userId;

	/** メールアドレス */
	@Column(name = "MAIL_ADDRESS", nullable = false)
	private String mailAddress;

	/** メールパスワード */
	@Column(name = "MAIL_PASSWORD", nullable = false)
	private String mailPassword;

	/** 更新日時 */
	@Column(name = "UPDATE_DATE", nullable = true)
	private Date updateDate;

	/** 登録日時 */
	@Column(name = "REG_DATE", nullable = false)
	private Date regDate;

}
