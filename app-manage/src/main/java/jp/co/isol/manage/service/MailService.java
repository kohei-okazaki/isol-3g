package jp.co.isol.manage.service;

import jp.co.isol.manage.form.HealthInfoInputForm;

/**
 * @author kou1210hei<br>
 * メールサービスインターフェイス
 *
 */
public interface MailService {

	/**
	 * メールを送信する<br>
	 * @param form
	 */
	public void sendMail(HealthInfoInputForm form);

}
