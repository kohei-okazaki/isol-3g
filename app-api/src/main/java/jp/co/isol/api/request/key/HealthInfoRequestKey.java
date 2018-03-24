package jp.co.isol.api.request.key;

import jp.co.isol.common.web.api.BaseRequestKey;

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

	private String value;

	private HealthInfoRequestKey(String value) {
		this.value = value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getValue() {
		return this.value;
	}

	/**
	 * 指定された値と一致するEnumを返す<br>
	 */
	public static BaseRequestKey of(String value) {

		for (HealthInfoRequestKey key : HealthInfoRequestKey.class.getEnumConstants()) {
			if (key.value.equals(value)) {
				return key;
			}
		}
		return null;
	}
}
