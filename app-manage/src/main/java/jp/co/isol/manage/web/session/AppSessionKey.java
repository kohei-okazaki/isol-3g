package jp.co.isol.manage.web.session;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * ログイン後のアプリで保持するセッションキー
 *
 */
public enum AppSessionKey {

	/** ID */
	ID("id");

	@Setter(value = AccessLevel.PRIVATE)
	@Getter
	private String name;

	private AppSessionKey(String name) {
		setName(name);
	}

}
