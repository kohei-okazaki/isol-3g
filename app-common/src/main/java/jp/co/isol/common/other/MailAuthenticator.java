package jp.co.isol.common.other;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

import lombok.Getter;
import lombok.Setter;

public class MailAuthenticator extends Authenticator {

	@Setter
	@Getter
	private String mailAddress;

	@Setter
	@Getter
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
