package jp.co.isol.api.request.impl;

import java.math.BigDecimal;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import jp.co.isol.api.exception.impl.HealthInfoException;
import jp.co.isol.api.request.BaseRequest;
import jp.co.isol.common.util.CalcUtil;
import jp.co.isol.common.util.StringUtil;

/**
 * 健康情報リクエストマップクラス<br>
 *
 */
@Component
public class HealthInfoRequest extends BaseRequest {

	/**
	 * {@inheritDoc}
	 */
	public HealthInfoRequest() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRequest(HttpServletRequest request) {
		this.requestInfoMap.put("userId", request.getParameter("userId"));
		this.requestInfoMap.put("height", request.getParameter("height"));
		this.requestInfoMap.put("weight", request.getParameter("weight"));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void checkRequest() throws HealthInfoException {

		for (Entry<String, Object> entry : requestInfoMap.entrySet()) {
			String key = entry.getKey();
			String value = (String) entry.getValue();
			if (StringUtil.isEmpty(value)) {
				throw new HealthInfoException("request内のkey：" + key + "に対するvalue:" + value + "がnullまたは空文字です");
			}

			if ("height".equals(key) || "weight".equals(key)) {

				if (StringUtil.isHalfNumber(value)) {
					// "半角数字"でないのとき
					throw new HealthInfoException("request内のkey：" + key + "に対するvalue:" + value + "と半角数字ではないため不正です");
				}

				if (BigDecimal.ZERO.equals(new BigDecimal(value))) {
					// "0"のとき
					throw new HealthInfoException("request内のkey：" + key + "に対するvalue:" + value + "と不正です");
				}

				if (CalcUtil.MINUS.startsWith(value)) {
					// "マイナスの値"のとき
					throw new HealthInfoException("request内のkey：" + key + "に対するvalue:" + value + "とマイナスなので不正です");
				}
			}
		}
	}
}
