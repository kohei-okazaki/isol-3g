package jp.co.isol.manage.web.view;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * ビューEnum<br>
 * 画面遷移先定義<br>
 *
 */
public enum ManageView {

	LOGIN("login"),
	HEALTH_INFO_INPUT("healthInfo"),
	MENU("menu"),
	ERROR("error"),
	RESULT_REFFERNCE("result-reference"),
	ACCOUNT_SETTING("account-setting"),
	NOTICE_SETTING("notice-setting");

	@Getter
	@Setter(value = AccessLevel.PRIVATE)
	private String name;

	private ManageView(String name) {
		setName(name);
	}

}
