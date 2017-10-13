package jp.co.isol.manage.view;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author kou1210hei<br>
 * ページEnum
 *
 */
public enum PageView {

	INPUT("0"),
	CONFIRM("1"),
	COMPLETE("2");

	@Getter
	@Setter(value = AccessLevel.PRIVATE)
	private String value;

	private PageView(String value) {
		this.value = value;
	}

}
