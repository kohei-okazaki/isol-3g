package jp.co.isol.manage.service;

import jp.co.isol.manage.form.HealthInfoInputForm;

/**
 * メールサービスIF
 *
 */
public interface MailService {

	/**
	 * メールを送信する<br>
	 * @param form
	 */
	public void sendMail(HealthInfoInputForm form);

}
