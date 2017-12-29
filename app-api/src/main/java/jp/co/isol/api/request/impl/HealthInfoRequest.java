package jp.co.isol.api.request.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import jp.co.isol.api.request.BaseRequest;
import jp.co.isol.api.request.key.impl.HealthInfoRequestKey;

/**
 * 健康情報リクエスト情報保持クラス<br>
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
		super.requestInfoMap.put(HealthInfoRequestKey.USER_ID, request.getParameter("userId"));
		super.requestInfoMap.put(HealthInfoRequestKey.HEIGHT, request.getParameter("height"));
		super.requestInfoMap.put(HealthInfoRequestKey.WEIGHT, request.getParameter("weight"));
	}

}
