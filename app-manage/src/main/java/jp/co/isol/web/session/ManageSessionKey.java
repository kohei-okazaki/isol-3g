package jp.co.isol.web.session;

/**
 * ログイン後のアプリで保持するセッションキー
 *
 */
public enum ManageSessionKey {

	/** ユーザID */
	USER_ID("userId"),
	/** アカウント情報 */
	ACCOUNT("account");

	/** キー名 */
	private String name;

	/**
	 * コンストラクタ<br>
	 * @param name
	 */
	private ManageSessionKey(String name) {
		this.name= name;
	}

	/**
	 * キー名を返す<br>
	 * @return
	 */
	public String getName() {
		return this.name;
	}

}
