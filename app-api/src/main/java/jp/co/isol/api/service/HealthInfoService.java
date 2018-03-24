package jp.co.isol.api.service;

import jp.co.isol.api.exception.HealthInfoException;
import jp.co.isol.api.request.HealthInfoRequest;
import jp.co.isol.api.response.HealthInfoResponse;
import jp.co.isol.common.entity.HealthInfo;
import jp.co.isol.common.web.api.BaseApiService;

/**
 * 健康情報サービスインターフェース<br>
 *
 */
public interface HealthInfoService extends BaseApiService<HealthInfoRequest, HealthInfoResponse, HealthInfoException> {

	/**
	 * 健康情報Entityを健康情報レスポンスクラスに変換する<br>
	 * @param healthInfo
	 * @return
	 */
	HealthInfoResponse toResponse(HealthInfo healthInfo);

	/**
	 * 健康情報にリクエスト情報をつめる
	 * @param request
	 * @return
	 */
	HealthInfo toEntity(HealthInfoRequest request);

}
