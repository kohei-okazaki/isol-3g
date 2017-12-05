package jp.co.isol.common.other;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * キャラセットEnum<br>
 *
 */
public enum Charset {

	MS_932("MS932"),
	UTF_8("UTF-8");

	@Getter
	@Setter(value = AccessLevel.PRIVATE)
	private String name;

	private Charset(String name) {
		setName(name);
	}
}
