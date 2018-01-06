package jp.co.isol.common.web.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

/**
 * 健康管理APIの基底リクエストクラス<br>
 *
 */
public abstract class BaseRequest {

	/** リクエストマップ */
	protected Map<BaseRequestKey, Object> requestInfoMap;

	/**
	 * コンストラクタ<br>
	 */
	public BaseRequest() {
		this.requestInfoMap = new HashMap<BaseRequestKey, Object>();
	}

	/**
	 * リクエスト情報をセットする<br>
	 * @param request
	 */
	protected abstract void setRequest(HttpServletRequest request);

	/**
	 * リクエストマップのキーに紐付くvalueを返す<br>
	 * マッピングされていない値を指定した場合、nullを返す<br>
	 * @param key
	 * @return
	 */
	public Object get(BaseRequestKey key) {
		return this.requestInfoMap.get(key);
	}

	/**
	 * リクエストマップ内のキーをすべて返す<br>
	 * @return
	 */
	public List<BaseRequestKey> getKeys() {
 		return new ArrayList<BaseRequestKey>(this.requestInfoMap.keySet());
	}

	/**
	 * リクエストマップ内のkey, valueをentrySetで返す<br>
	 * @return
	 */
	public Set<Entry<BaseRequestKey, Object>> getKeyValue() {
		return this.requestInfoMap.entrySet();
	}

	/**
	 * リクエストマップ内に指定したキーが存在するか判定する<br>
	 * 存在する場合true, それ以外の場合はfalseを返す<br>
	 * @param key
	 * @return
	 */
	public boolean contains(BaseRequestKey key) {
		return Objects.isNull(key) ? false : this.requestInfoMap.containsKey(key);
	}

	/**
	 * リクエストマップ内が空かどうか判定する<br>
	 * 空のマップの場合true, 空でない場合false<br>
	 * @return
	 */
	public boolean isEmpty() {
		return this.requestInfoMap.isEmpty();
	}

	/**
	 * リクエストマップ内が空でない場合true, 空の場合falseを返す<br>
	 * @return
	 */
	public boolean isNotEmpty() {
		return !isEmpty();
	}

}
