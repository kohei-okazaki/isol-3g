package jp.co.isol.api.request.impl;

import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import jp.co.isol.api.exception.impl.HealthInfoException;
import jp.co.isol.api.request.BaseRequest;
import jp.co.isol.common.util.StringUtil;

/**
 * 健康情報リクエストマップクラス<br>
 *
 */
public class HealthInfoRequest extends BaseRequest {

	/**
	 * コンストラクタ<br>
	 * 入力された値を詰める
	 * @param request
	 */
	public HealthInfoRequest(HttpServletRequest request) {
		super();
		this.requestInfoMap.put("userId", request.getParameter("userId"));
		this.requestInfoMap.put("height", request.getParameter("height"));
		this.requestInfoMap.put("weight", request.getParameter("weight"));
	}

	/**
	 * 不正なリクエスト情報の場合falseを返す<br>
	 * @throws HealthInfoException
	 */
	@Override
	public void checkRequest() throws HealthInfoException {

		// nullまたは空文字のチェックを行う
		for (Entry<String, Object> entry : requestInfoMap.entrySet()) {
			if (StringUtil.isEmpty((String) this.requestInfoMap.get(entry.getKey()))) {
				throw new HealthInfoException("request内のkey：" + entry.getKey() + "value:" + this.requestInfoMap.get(entry.getKey()));
			}
		}


	}
}
