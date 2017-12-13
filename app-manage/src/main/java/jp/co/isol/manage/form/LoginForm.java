package jp.co.isol.manage.form;

import java.io.Serializable;

import javax.validation.constraints.Max;

import lombok.Data;

/**
 * ログインフォームクラス
 *
 */
@Data
public class LoginForm implements Serializable {

	/** ユーザID */
	@Max(10)
	private String userId;

	/** パスワード */
	@Max(10)
	private String password;

}
