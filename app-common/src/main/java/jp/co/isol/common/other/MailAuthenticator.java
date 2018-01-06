package jp.co.isol.common.other;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuthenticator extends Authenticator {

	private String mailAddress;

	private String password;

	public MailAuthenticator(String mailAddress, String password) {
		this.mailAddress = mailAddress;
		this.password = password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {

		PasswordAuthentication auth = new PasswordAuthentication(this.mailAddress, this.password);
		return auth;
	}

}
