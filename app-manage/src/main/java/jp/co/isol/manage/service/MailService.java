package jp.co.isol.manage.service;

import jp.co.isol.manage.form.MenuForm;

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
	public void sendMail(MenuForm form);

}
