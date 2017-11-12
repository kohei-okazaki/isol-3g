package jp.co.isol.manage.web.session;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * ログイン後のアプリで保持するセッションキー
 *
 */
public enum ManageSessionKey {

	/** ユーザID */
	USER_ID("userId");

	@Setter(value = AccessLevel.PRIVATE)
	@Getter
	private String name;

	private ManageSessionKey(String name) {
		setName(name);
	}

}
