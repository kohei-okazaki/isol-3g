package jp.co.isol.web.service;

import jp.co.isol.common.entity.Account;
import jp.co.isol.common.entity.MailInfo;
import jp.co.isol.web.form.AccountSettingForm;

/**
 * アカウント設定サービスインターフェース<br>
 *
 */
public interface AccountSettingService {

	/**
	 * 更新処理を行う<br>
	 * @param account
	 * @param mainlInfo
	 */
	public void update(Account account, MailInfo mainlInfo);

	/**
	 * 指定されたアカウント情報の削除をする<br>
	 * @param form
	 */
	public void deleteAccount(AccountSettingForm form);

	/**
	 * フォーム情報をアカウント情報にマージする<br>
	 * @param account
	 * @param form
	 * @return
	 */
	public Account mergeAccount(Account account, AccountSettingForm form);

	/**
	 * フォーム情報をメール情報に変換する<br>
	 * @param form
	 * @return
	 */
	public MailInfo convertMailInfo(AccountSettingForm form);

	/**
	 * アカウント情報を更新する
	 * @param account
	 */
	public void updateAccount(Account account);

	/**
	 * フォーム情報をメール情報にマージする<br>
	 * @param mailInfo
	 * @param form
	 * @return
	 */
	public MailInfo mergeMailInfo(MailInfo mailInfo, AccountSettingForm form);

}
