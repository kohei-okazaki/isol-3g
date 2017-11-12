package jp.co.isol.manage.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import jp.co.isol.common.other.MailAuthenticator;
import jp.co.isol.common.util.MailUtil;
import jp.co.isol.common.util.StringUtil;
import jp.co.isol.manage.form.HealthInfoForm;
import jp.co.isol.manage.service.MailService;

/**
 * メールサービス実装クラス
 */
@Service
public class MailServiceImpl implements MailService {

	/**
	 * メールを送信する
	 *
	 */
	@Override
	public void sendMail(HealthInfoForm form) {

		Properties prop = new Properties();
		prop.setProperty(MailUtil.SMTP_HOST, "smtp.gmail.com");
		prop.setProperty(MailUtil.SMTP_PORT, "465");

		// タイムアウト設定
		prop.setProperty(MailUtil.SMTP_CON_TIMEOUT, "60000");
		prop.setProperty(MailUtil.SMTP_TIMEOUT, "60000");

		// 認証
		prop.setProperty(MailUtil.SMTP_AUTH, "true");

		// SSLを使用するとこはこの設定が必要
		prop.setProperty(MailUtil.SMTP_SOCKET_CLASS, "javax.net.ssl.SSLSocketFactory");
		prop.setProperty(MailUtil.SMTP_SOCKET_FALLBACK, "false");
		prop.setProperty(MailUtil.SMTP_SOCKET_PORT, "465");

		Authenticator auth = new MailAuthenticator("kou1210hei@gmail.com", "oka1210hei");

		MimeMessage mime = new MimeMessage(Session.getInstance(prop, auth));

		try {
			mime.setRecipient(MimeMessage.RecipientType.TO, createTo());
			mime.setFrom(createFrom());
			mime.setSubject("ここがタイトル");
			mime.setText(createBody(form));

			// その他の付加情報
			mime.addHeader("X-Mailer", "blancoMail 0.1");
			mime.setSentDate(new Date());
			//			mime.saveChanges();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			System.out.println("-----> メール宛先などの設定完了");
		}

		try {
			Transport.send(mime);
		} catch (AuthenticationFailedException e) {
			// 認証失敗
			System.out.println("-----> 認証失敗");
			e.printStackTrace();
		} catch (MessagingException e) {
			// SMTPサーバへの接続失敗
			System.out.println("-----> SMTPサーバへの接続失敗");
			e.printStackTrace();
		}
	}

	/**
	 * 本文を作成する
	 * @param form
	 */
	private String createBody(HealthInfoForm form) {
		StringBuilder sb = new StringBuilder();
		sb.append("身長　：　" + form.getHeight() + StringUtil.NEW_LINE);
		sb.append("体重　：　" + form.getWeight() + StringUtil.NEW_LINE);
		sb.append("BMI　：　" + form.getBmi() + StringUtil.NEW_LINE);
		sb.append("標準体重　：　" + form.getStandardWeight() + StringUtil.NEW_LINE);
		return sb.toString();
	}

	private Address createFrom() throws UnsupportedEncodingException {
		return new InternetAddress("kou1210hei@gmail.com", "送信者", MailUtil.ENCODE);
	}

	private Address createTo() throws UnsupportedEncodingException {
		return new InternetAddress("k-okazaki@i-sol.co.jp", "送信者", MailUtil.ENCODE);
	}


}
