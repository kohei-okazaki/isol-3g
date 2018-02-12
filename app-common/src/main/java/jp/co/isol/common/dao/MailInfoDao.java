package jp.co.isol.common.dao;

import org.springframework.dao.DuplicateKeyException;

import jp.co.isol.common.entity.MailInfo;

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
	public MailInfo getMailInfoByUserId(String userId);

	/**
	 * 引数で指定されたメール情報を更新する
	 * @param mailInfoDto
	 */
	public void updateMailInfo(MailInfo mailInfo);


	/**
	 * 引数で指定されたメール情報を登録する<br>
	 * @param mailInfoDto
	 */
	public void registMailInfo(MailInfo mailInfo) throws DuplicateKeyException;
}
