package jp.co.isol.common.dao;

import jp.co.isol.common.dto.MailInfoDto;

/**
 * メール情報のDaoインターフェース
 *
 */
public interface MailInfoDao {

	/**
	 * 引数で指定されたユーザIDのメール情報を取得する
	 * @param userId
	 * @return AccountDto
	 */
	public MailInfoDto getAccountByUserId(String userId);

}
