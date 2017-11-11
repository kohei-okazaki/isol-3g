package jp.co.isol.api.request;

import java.util.HashMap;
import java.util.Map;

import jp.co.isol.api.exception.BaseApiException;

/**
 * 健康管理APIのbaseリクエストマップ<br>
 *
 */
public abstract class BaseRequest {

	/** リクエストマップ */
	protected Map<String, Object> requestInfoMap;

	/**
	 * コンストラクタ<br>
	 */
	public BaseRequest() {
		this.requestInfoMap = new HashMap<String, Object>();
	}

	/**
	 * リクエストマップのキーに紐付くvalueを返す<br>
	 * マッピングされていない値を指定した場合、nullを返す<br>
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		return this.requestInfoMap.get(key);
	}

	/**
	 * 継承先でそれぞれチェックを実装
	 * @throws BaseApiException
	 */
	public abstract void checkRequest() throws BaseApiException;


}
