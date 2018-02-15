package jp.co.isol.common.dao;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;

import jp.co.isol.common.entity.HealthInfo;

/**
 * 健康情報のDaoインターフェイス
 *
 */
public interface HealthInfoDao extends BaseDao {

	/** 保存先シート名 */
	public static final String SHEET = "HEALTH_INFO";

	/**
	 * 指定したユーザIDの健康情報を返す<br>
	 * @param userId
	 * @return List<HealthInfo>
	 */
	public List<HealthInfo> getHealthInfoByUserId(String userId);

	/**
	 * 指定されたデータIDに対応する健康情報を返す<br>
	 * @param dataId
	 * @return HealthInfo
	 */
	public HealthInfo getHealthInfoByDataId(String dataId);

	/**
	 * 健康情報を登録する<br>
	 * @param dto
	 * @throws DuplicateKeyException
	 */
	public void registHealthInfo(HealthInfo healthInfo) throws DuplicateKeyException;

	/**
	 * 指定したユーザIDで最後に登録した健康情報を返す<br>
	 * @param userId
	 * @return HealthInfo
	 */
	public HealthInfo getLastHealthInfoById(String userId);

}
