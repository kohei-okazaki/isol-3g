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
	 * 全ユーザ情報を検索
	 * @param userId
	 * @return result
	 */
	public List<HealthInfoDto> getHealthInfoByUserId(String userId) throws ParseException;

	/**
	 * 引数で指定されたIDのレコードを返す
	 * @param dataId
	 * @return レコード
	 */
	public HealthInfoDto getHealthInfoByDataId(String dataId) throws ParseException;

	/**
	 * ユーザ情報を登録する
	 * @param dto
	 */
	public void registHealthInfo(HealthInfoDto dto);

}
