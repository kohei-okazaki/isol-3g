package jp.co.isol.manage.form;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * ログインフォームクラス
 *
 */
@Data
public class LoginForm implements Serializable {

	/** ユーザID */
	@Max(10)
	@NotBlank
	private String userId;

	/** パスワード */
	@Max(10)
	@NotBlank
	private String password;

}
