package jp.co.isol.api.service;

import java.text.ParseException;

import jp.co.isol.api.exception.impl.HealthInfoException;
import jp.co.isol.api.request.impl.HealthInfoRequest;
import jp.co.isol.common.dto.HealthInfoDto;

/**
 * 健康情報サービスIF<br>
 *
 */
public abstract class HealthInfoService implements BaseApiService<HealthInfoRequest, HealthInfoException> {

	/**
	 * メイン処理<br>
	 * @param request
	 * @return 健康情報Dto
	 * @throws ParseException
	 */
	public abstract HealthInfoDto execute(HealthInfoRequest request) throws ParseException;

}
