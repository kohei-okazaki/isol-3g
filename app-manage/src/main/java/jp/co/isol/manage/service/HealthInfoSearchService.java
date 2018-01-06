package jp.co.isol.manage.service;

import java.text.ParseException;
import java.util.List;

import jp.co.isol.common.dto.HealthInfoDto;

/**
 * 健康情報検索インターフェース<br>
 *
 */
public interface HealthInfoSearchService {

	/**
	 * 指定されたユーザIDと一致する健康情報のリストを返却する<br>
	 * @param userId
	 * @return List<HealthInfoDto>
	 * @throws ParseException
	 */
	public List<HealthInfoDto> findHealthInfoByUserId(String userId);

	/**
	 * 指定されたデータIDからと一致する健康情報を返却する<br>
	 * @param dataId
	 * @return HealthInfoDto
	 * @throws ParseException
	 */
	public HealthInfoDto findHealthInfoByDataId(String dataId);
}
