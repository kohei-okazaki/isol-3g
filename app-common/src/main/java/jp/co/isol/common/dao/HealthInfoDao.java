package jp.co.isol.common.dao;

import java.text.ParseException;
import java.util.List;

import jp.co.isol.common.dto.HealthInfoDto;

/**
 * 健康情報のDaoインターフェイス
 *
 */
public interface HealthInfoDao {

	/**
	 * 指定したユーザIDの健康情報を返す
	 * @param userId
	 * @return result
	 * @throws ParseException
	 */
	public List<HealthInfoDto> getHealthInfoByUserId(String userId) throws ParseException;

	/**
	 * 指定されたデータIDに対応する健康情報を返す
	 * @param dateId
	 * @return HealthInfoDto
	 * @throws ParseException
	 */
	public HealthInfoDto getHealthInfoByDataId(String dataId) throws ParseException;

	/**
	 * 健康情報を登録する<br>
	 * @param dto
	 */
	public void registHealthInfo(HealthInfoDto dto);

}
