package jp.co.isol.api.request.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import jp.co.isol.api.request.BaseRequest;

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
		this.requestInfoMap.put(HealthInfoRequestKey.USER_ID, request.getParameter("userId"));
		this.requestInfoMap.put(HealthInfoRequestKey.HEIGHT, request.getParameter("height"));
		this.requestInfoMap.put(HealthInfoRequestKey.WEIGHT, request.getParameter("weight"));
	}

}
