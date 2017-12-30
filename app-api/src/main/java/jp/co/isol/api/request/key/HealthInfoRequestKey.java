package jp.co.isol.api.request.key;

import jp.co.isol.common.web.api.BaseRequestKey;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * 健康情報リクエストキー定義<br>
 *
 */
public enum HealthInfoRequestKey implements BaseRequestKey {

	/** ユーザID */
	USER_ID("userId"),
	/** 身長 */
	HEIGHT("height"),
	/** 体重 */
	WEIGHT("weight");

	@Getter
	@Setter(value = AccessLevel.PRIVATE)
	private String value;

	private HealthInfoRequestKey(String value) {
		setValue(value);
	}
}
