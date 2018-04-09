package jp.co.isol.web.service;

import jp.co.isol.web.form.HealthInfoForm;

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
