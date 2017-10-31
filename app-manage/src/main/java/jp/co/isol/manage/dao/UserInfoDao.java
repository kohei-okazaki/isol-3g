package jp.co.isol.manage.dao;

import java.text.ParseException;
import java.util.List;

import jp.co.isol.manage.dto.UserInfoDto;


/**
 * ユーザー情報のDBアクセスインターフェース
 *
 */
public interface UserInfoDao {

	/**
	 * 全ユーザ情報を検索
	 * @param userId
	 * @return result
	 */
	public List<UserInfoDto> getUserInfoByUserId(String userId) throws ParseException;

	/**
	 * 引数で指定されたIDのレコードを返す
	 * @param dataId
	 * @return レコード
	 */
	public UserInfoDto getUserInfoByDataId(String dataId) throws ParseException;

	/**
	 * ユーザ情報を登録する
	 * @param dto
	 */
	public void registUserUnfo(UserInfoDto dto);

}
