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
	public default HealthInfoResponse toResponse(HealthInfoDto dto) {

		HealthInfoResponse response = new HealthInfoResponse();
		response.setDataId(dto.getDataId());
		response.setUserId(dto.getUserId());
		response.setHeight(dto.getHeight());
		response.setWeight(dto.getWeight());
		response.setBmi(dto.getBmi());
		response.setStandardWeight(dto.getStandardWeight());
		response.setUserStatus(dto.getUserStatus());
		response.setRegDate(dto.getRegDate());

		return response;
	}
}
