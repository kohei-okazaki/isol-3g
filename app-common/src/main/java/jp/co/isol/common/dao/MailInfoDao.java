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
	public MailInfoDto getMailInfoByUserId(String userId);

	/**
	 * 引数で指定されたメール情報を更新する
	 * @param mailInfoDto
	 */
	public void updateMailInfo(MailInfoDto mailInfoDto);


	/**
	 * 引数で指定されたメール情報を登録する<br>
	 * @param mailInfoDto
	 */
	public void registMailInfo(MailInfoDto mailInfoDto);
}
