package jp.co.isol.api.service;

import jp.co.isol.api.exception.BaseApiException;
import jp.co.isol.api.request.BaseRequest;

/**
 * 基底APIサービス<br>
 * 各機能のサービスの親クラスとする<br>
 * @param T リクエスト種別
 * @param E 例外種別
 */
public interface BaseApiService<T extends BaseRequest, E extends BaseApiException> {

	/**
	 * 継承先でそれぞれチェックを実装<br>
	 * @param T Request実装クラス
	 * @throws E 例外実装クラス
	 */
	void checkRequest(T request) throws E;

}
