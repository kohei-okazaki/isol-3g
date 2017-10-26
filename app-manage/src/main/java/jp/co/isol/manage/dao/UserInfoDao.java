package jp.co.isol.manage.dao;

import java.util.List;

import jp.co.isol.manage.dto.UserInfoDto;
import jp.co.isol.manage.form.MenuForm;


/**
 * ユーザー情報のDBアクセスインターフェース
 *
 */
public interface UserInfoDao {

	/**
	 * 全ユーザ情報を検索
	 * @return result
	 */
	public List<UserInfoDto> getUserAllData();

	/**
	 * 引数で指定されたIDのレコードを返す
	 * @param id
	 * @return レコード
	 */
	public UserInfoDto getUserInfoByUserId(String id);

	/**
	 * ユーザ情報を登録する
	 * @param menuForm
	 */
	public void registUserUnfo(MenuForm menuForm);

}
