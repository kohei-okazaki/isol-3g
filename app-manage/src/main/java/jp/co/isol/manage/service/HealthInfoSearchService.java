package jp.co.isol.manage.service;

import java.text.ParseException;
import java.util.List;

import jp.co.isol.manage.dto.HealthInfoDto;

/**
 * @author kou1210hei<br>
 * ユーザ情報検索インターフェイス
 *
 */
public interface HealthInfoSearchService {

	/**
	 * 全ユーザ情報を取得する
	 * @param userId
	 * @return List<HealthInfoDto> 全ユーザ情報
	 */
	public List<HealthInfoDto> findHealthInfoByUserId(String userId) throws ParseException;

	/**
	 * 指定されたIDからユーザ情報を取得する
	 * @param dataId
	 * @return HealthInfoDto
	 */
	public HealthInfoDto findHealthInfoByDataId(String dataId) throws ParseException;
}
