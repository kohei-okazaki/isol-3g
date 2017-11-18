package jp.co.isol.manage.form;

import java.io.Serializable;

import lombok.Data;

/**
 * ログインフォームクラス
 *
 */
@Data
public class LoginUserForm implements Serializable {

	/** ユーザID */
	private String userId;

	/** パスワード */
	private String password;

}
