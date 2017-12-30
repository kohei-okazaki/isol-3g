package jp.co.isol.api.service;

import jp.co.isol.api.request.BaseRequest;
import jp.co.isol.common.exception.BaseApiException;

/**
 * 基底APIサービス<br>
 * 各機能のサービスの親クラスとする<br>
 * @param R リクエスト種別
 * @param E 例外種別
 */
public interface BaseApiService<R extends BaseRequest, E extends BaseApiException> {

	/**
	 * 継承先でそれぞれチェックを実装<br>
	 * @param T Request実装クラス
	 * @throws E 例外実装クラス
	 */
	public void checkRequest(R request) throws E;

}
