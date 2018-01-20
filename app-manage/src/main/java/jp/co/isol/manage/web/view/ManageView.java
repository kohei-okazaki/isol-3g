package jp.co.isol.manage.web.view;

/**
 * ビューEnum<br>
 * 画面遷移先定義<br>
 *
 */
public enum ManageView {

	/** ログイン画面URL */
	LOGIN("login"),
	/** 健康情報画面URL */
	HEALTH_INFO("healthInfo"),
	/** メニュー画面URL */
	MENU("menu"),
	/** エラー画面URL */
	ERROR("error"),
	/** 結果照会画面URL */
	RESULT_REFFERNCE("result-reference"),
	/** アカウント設定画面URL */
	ACCOUNT_SETTING("account-setting"),
	/** 通知設定画面URL */
	NOTICE_SETTING("notice-setting"),
	/** アカウント作成画面URL */
	ACCOUNT_CREATE("account-create");

	/** view名 */
	private String name;

	/**
	 * コンストラクタ<br>
	 * @param name
	 */
	private ManageView(String name) {
		this.name= name;
	}

	/**
	 * 名前を返す
	 * @return
	 */
	public String getName() {
		return this.name;
	}

}
