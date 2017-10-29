package jp.co.isol.manage.form;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author kou1210hei<br>
 * ログインフォームクラス
 *
 */
public class LoginUserForm implements Serializable {

	/** ID */
	@Setter
	@Getter
	private String userId;

	/** パスワード */
	@Setter
	@Getter
	private String password;

}
