package jp.co.isol.manage.form;

import java.io.Serializable;

import lombok.Data;

/**
 * アカウント設定画面フォームクラス<br>
 *
 */
@Data
public class AccountSettingForm implements Serializable {

	/** ユーザID */
	private String userId;

	/** パスワード */
	private String password;

	/** 削除フラグ */
	private boolean deleteFlag;

}
