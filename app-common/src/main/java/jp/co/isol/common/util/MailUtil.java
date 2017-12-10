package jp.co.isol.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * メールのUtilクラス
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MailUtil {

	/** エンコード */
	public static final String ENCODE = "ISO-2022-JP";

	public static final String SMTP_HOST = "mail.smtp.host";

	public static final String SMTP_PORT = "mail.smtp.port";

	public static final String SMTP_CON_TIMEOUT = "mail.smtp.connectiontimeout";

	public static final String SMTP_TIMEOUT = "mail.smtp.timeout";

	public static final String SMTP_AUTH = "mail.smtp.auth";

	public static final String SMTP_SOCKET_CLASS = "mail.smtp.socketFactory.class";

	public static final String SMTP_SOCKET_FALLBACK = "mail.smtp.socketFactory.fallback";

	public static final String SMTP_SOCKET_PORT = "mail.smtp.socketFactory.port";

}
