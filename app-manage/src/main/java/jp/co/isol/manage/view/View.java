package jp.co.isol.manage.view;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * ビューEnum
 *
 */
public enum View {

	LOGIN("login"),
	HEALTH_INFO_INPUT("healthInfoInput"),
	MENU("menu"),
	ERROR("error"),
	RESULT_REFFERNCE("result-reference"),
	ACCOUNT_SETTING("account-setting"),
	NOTICE_SETTING("notice-setting");

	@Getter
	@Setter(value = AccessLevel.PRIVATE)
	private String name;

	private View(String name) {
		this.name = name;
	}

}
