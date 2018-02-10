package jp.co.isol.manage.service;

import java.util.List;

import jp.co.isol.common.entity.HealthInfo;

/**
 * 健康情報検索インターフェース<br>
 *
 */
public interface HealthInfoSearchService {

	/**
	 * 指定されたユーザIDと一致する健康情報のリストを返却する<br>
	 * @param userId
	 * @return List<HealthInfoDto>
	 */
	public List<HealthInfo> findHealthInfoByUserId(String userId);

	/**
	 * 指定されたデータIDからと一致する健康情報を返却する<br>
	 * @param dataId
	 * @return HealthInfoDto
	 */
	public HealthInfo findHealthInfoByDataId(String dataId);
}
