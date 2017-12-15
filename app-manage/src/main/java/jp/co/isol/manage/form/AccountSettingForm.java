package jp.co.isol.manage.form;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * アカウント設定画面フォームクラス<br>
 *
 */
@Data
public class AccountSettingForm extends BaseForm implements Serializable {

	/** ユーザID */
	@Max(10)
	@NotBlank
	private String userId;

	/** パスワード */
	@Max(10)
	private String password;

	/** 削除フラグ */
	@Max(1)
	private boolean deleteFlag;

}
