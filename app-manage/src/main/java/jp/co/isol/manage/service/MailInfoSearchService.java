package jp.co.isol.manage.service;

import jp.co.isol.common.dto.MailInfoDto;

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
	public MailInfoDto findMailInfoByUserId(String userId);

}
