package jp.co.isol.api.service;

import java.text.ParseException;

import jp.co.isol.api.request.impl.HealthInfoRequest;
import jp.co.isol.common.dto.HealthInfoDto;


/**
 * 健康情報サービスIF<br>
 *
 */
public interface HealthInfoService extends BaseApiService {

	/**
	 * メイン処理<br>
	 * @param request
	 * @return 健康情報Dto
	 * @throws ParseException
	 */
	public HealthInfoDto execute(HealthInfoRequest request) throws ParseException;

}
