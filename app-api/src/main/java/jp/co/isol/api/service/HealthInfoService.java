package jp.co.isol.api.service;

import jp.co.isol.api.exception.HealthInfoException;
import jp.co.isol.api.request.HealthInfoRequest;
import jp.co.isol.api.response.HealthInfoResponse;
import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.common.web.api.BaseApiService;

/**
 * 健康情報サービスインターフェース<br>
 *
 */
public interface HealthInfoService extends BaseApiService<HealthInfoRequest, HealthInfoResponse, HealthInfoException> {

	/**
	 * 健康情報Dtoを健康情報レスポンスクラスに変換する<br>
	 * @param dto
	 * @return
	 */
	public HealthInfoResponse toResponse(HealthInfoDto dto);

}
