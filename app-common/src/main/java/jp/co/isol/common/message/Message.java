package jp.co.isol.common.message;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @kou1210hei<br>
 * JSPで表示する文言を管理
 *
 */
public enum Message {
	WEIGHT("体重"),
	HEIGHT("身長"),
	BMI("BMI"),
	STANDARDWEIGHT("標準体重"),
	UP("増えました"),
	DOWN("減りました");

	@Getter
	@Setter(value = AccessLevel.PRIVATE)
	private String name;

	private Message(String name) {
		setName(name);
	}

}
