package jp.co.isol.manage.service;

import jp.co.isol.manage.form.HealthInfoForm;

/**
 * メールサービスインターフェース<br>
 *
 */
public interface MailService {

	/**
	 * メールを送信する<br>
	 * @param form
	 */
	public void sendMail(HealthInfoForm form);

}
