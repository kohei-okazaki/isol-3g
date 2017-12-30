package jp.co.isol.manage.form;

import java.io.Serializable;

import jp.co.isol.common.mvc.BaseForm;
import lombok.Getter;
import lombok.Setter;

/**
 * ログインフォームクラス
 *
 */
public class LoginForm extends BaseForm implements Serializable {

	/** ユーザID */
	@Setter
	@Getter
	private String userId;

	/** パスワード */
	@Setter
	@Getter
	private String password;

}
