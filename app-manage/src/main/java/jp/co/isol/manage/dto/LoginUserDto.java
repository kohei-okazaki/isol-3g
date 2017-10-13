package jp.co.isol.manage.dto;

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
 * @author kou1210hei<br>
 * ログインユーザのDto
 *
 */
@Entity
@Table(name = "LOGIN_USER")
@ToString(exclude = "password")
public class LoginUserDto implements Serializable {

	@Id
	@Column(name = "ID", nullable = false, length = 3)
	@Setter
	@Getter
	private String id;

	@Column(name = "PASSWORD", nullable = false)
	@Setter
	@Getter
	private String password;

	@Column(name = "RECORD_DATE", nullable = false)
	@Setter
	@Getter
	private Date recordDate;

}
