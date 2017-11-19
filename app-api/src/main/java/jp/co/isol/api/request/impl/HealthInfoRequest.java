package jp.co.isol.api.request.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import jp.co.isol.api.request.BaseRequest;

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

}
