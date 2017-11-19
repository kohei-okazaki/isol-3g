package jp.co.isol.api.service;

import jp.co.isol.api.exception.BaseApiException;
import jp.co.isol.api.request.BaseRequest;

public interface BaseApiService {

	/**
	 * 継承先でそれぞれチェックを実装
	 * @throws BaseApiException
	 */
	public void checkRequest(BaseRequest request) throws BaseApiException;

}
