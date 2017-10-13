package jp.co.isol.common.other;

import lombok.Getter;

public enum Charset {

	MS_932("MS932"),
	UTF_8("UTF-8");

	@Getter
	private String name;

	private Charset(String name) {
		this.name = name;
	}
}
