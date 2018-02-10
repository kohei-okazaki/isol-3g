package jp.co.isol.manage.service;

import jp.co.isol.common.entity.MailInfo;

/**
 * メール情報検索サービスインターフェース<br>
 *
 */
public interface MailInfoSearchService {

	/**
	 * ユーザIDからメール情報を取得する
	 * @param userId
	 * @return メール情報
	 */
	public MailInfo findMailInfoByUserId(String userId);

}
