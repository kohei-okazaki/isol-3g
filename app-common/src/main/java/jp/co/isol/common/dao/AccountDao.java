package jp.co.isol.common.dao;

import org.springframework.dao.DuplicateKeyException;

import jp.co.isol.common.entity.Account;

/**
 * アカウント情報のDaoインターフェイス
 *
 */
public interface AccountDao extends BaseDao {

	/** 保存先シート名 */
	public static final String SHEET = "ACCOUNT";

	/**
	 * 引数で指定されたユーザIDのアカウント情報を取得する
	 * @param userId
	 * @return AccountDto
	 */
	public Account getAccountByUserId(String userId);


	/**
	 * アカウント情報を登録する<br>
	 * @param accountDto
	 * @throws DuplicateKeyException
	 */
	public void registAccount(Account account) throws DuplicateKeyException;

	/**
	 * 引数で指定されたアカウント情報を更新する
	 * @param accountDto
	 */
	public void updateAccount(Account account);

	/**
	 * 指定されたアカウント情報の削除を行う<br>
	 * @param userId
	 */
	public void deleteAccount(String userId);

}
