package jp.co.isol.api.request.check;

import java.math.BigDecimal;

import jp.co.isol.api.exception.HealthInfoException;
import jp.co.isol.api.request.key.impl.HealthInfoRequestKey;
import jp.co.isol.common.util.StringUtil;

/**
 * 健康情報のチェックを行うクラス<br>
 *
 */
public class HealthInfoCheck {

	/**
	 * 必須チェックを行う<br>
	 * @param key
	 * @param value
	 * @throws HealthInfoException
	 */
	public void checkRequired(String key, String value) throws HealthInfoException {
		if (StringUtil.isEmpty(value)) {
			throw new HealthInfoException("request内のkey：" + key + "に対するvalue:" + value + "がnullまたは空文字です");
		}
	}

	/**
	 * 属性チェックを行う<br>
	 * @param key
	 * @param value
	 * @throws HealthInfoException
	 */
	public void checkType(String key, String value) throws HealthInfoException {

		if (HealthInfoRequestKey.HEIGHT.getValue().equals(key)
				|| HealthInfoRequestKey.WEIGHT.getValue().equals(key)) {
			// 身長 or 体重のとき

			if (StringUtil.isHalfNumberPeriod(value)) {
				// "半角数字 or ピリオド"でないとき
				throw new HealthInfoException("request内のkey：" + key + "に対するvalue:" + value + "と半角数字とピリオドではないため不正です");
			}
		}
	}

	/**
	 * 0チェックを行う<br>
	 * @param key
	 * @param value
	 * @throws HealthInfoException
	 */
	public void checkZero(String key, String value) throws HealthInfoException {

		if (HealthInfoRequestKey.HEIGHT.getValue().equals(key)
				|| HealthInfoRequestKey.WEIGHT.getValue().equals(key)) {
			// 身長 or 体重のとき

			if (BigDecimal.ZERO.equals(new BigDecimal(value))) {
				// "0"のとき
				throw new HealthInfoException("request内のkey：" + key + "に対するvalue:" + value + "と不正です");
			}
		}
	}
}
