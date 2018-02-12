package jp.co.isol.manage.service;

import jp.co.isol.common.entity.MailInfo;

/**
 * メール情報作成サービスインターフェース<br>
 *
 */
public interface MailInfoCreateService {

	/**
	 * メール情報を作成する<br>
	 * @param mailInfo
	 */
	public void create(MailInfo mailInfo);

}
