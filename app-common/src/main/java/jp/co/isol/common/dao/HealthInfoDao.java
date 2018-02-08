package jp.co.isol.common.dao;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;

import jp.co.isol.common.dto.HealthInfoDto;

/**
 * 健康情報のDaoインターフェイス
 *
 */
public interface HealthInfoDao {

	/**
	 * 指定したユーザIDの健康情報を返す<br>
	 * @param userId
	 * @return List<HealthInfoDto>
	 */
	public List<HealthInfoDto> getHealthInfoByUserId(String userId);

	/**
	 * 指定されたデータIDに対応する健康情報を返す<br>
	 * @param dataId
	 * @return HealthInfoDto
	 */
	public HealthInfoDto getHealthInfoByDataId(String dataId);

	/**
	 * 健康情報を登録する<br>
	 * @param dto
	 * @throws DuplicateKeyException
	 */
	public void registHealthInfo(HealthInfoDto dto) throws DuplicateKeyException;

}
