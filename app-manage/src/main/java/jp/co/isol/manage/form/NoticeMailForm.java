package jp.co.isol.manage.form;

import java.io.Serializable;

import lombok.Data;

/**
 * 送信するメールオブジェクトクラス
 *
 */
@Data
public class NoticeMailForm implements Serializable {

	/** from */
	private String from;

	/** subject */
	private String subject;

	/** body */
	private String body;

	/** to */
	private String to;

	/** cc */
	private String cc;

	/** bcc */
	private String bcc;

	/** replyTo */
	private String replyTo;

}
