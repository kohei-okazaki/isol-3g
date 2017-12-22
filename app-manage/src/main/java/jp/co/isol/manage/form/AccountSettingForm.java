package jp.co.isol.manage.form;

import java.io.Serializable;

import jp.co.isol.common.mvc.BaseForm;
import lombok.Getter;
import lombok.Setter;

/**
 * アカウント設定画面フォームクラス<br>
 *
 */
public class AccountSettingForm extends BaseForm implements Serializable {

	/** ユーザID */
	@Setter
	@Getter
	private String userId;

	/** パスワード */
	@Setter
	@Getter
	private String password;

	/** 削除フラグ */
	@Setter
	@Getter
	private boolean deleteFlag;

}
