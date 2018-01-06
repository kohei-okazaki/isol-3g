package jp.co.isol.manage.web.session;

/**
 * ログイン後のアプリで保持するセッションキー
 *
 */
public enum ManageSessionKey {

	/** ユーザID */
	USER_ID("userId");

	private String name;

	private ManageSessionKey(String name) {
		this.name= name;
	}

	public String getName() {
		return this.name;
	}

}
