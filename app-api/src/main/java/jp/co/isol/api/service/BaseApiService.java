package jp.co.isol.api.service;

import jp.co.isol.api.exception.BaseApiException;
import jp.co.isol.api.request.BaseRequest;

/**
 * 基底APIサービス<br>
 * 各サービスの親クラスとする<br>
 */
public interface BaseApiService {

	/**
	 * 継承先でそれぞれチェックを実装
	 * @throws BaseApiException
	 */
	public void checkRequest(BaseRequest request) throws BaseApiException;

}
