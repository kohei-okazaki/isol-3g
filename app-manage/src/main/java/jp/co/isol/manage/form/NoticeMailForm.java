package jp.co.isol.manage.form;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 送信するメールオブジェクトクラス
 *
 */
public class NoticeMailForm implements Serializable {

	/** from */
	@Setter
	@Getter
	private String from;

	/** subject */
	@Setter
	@Getter
	private String subject;

	/** body */
	@Setter
	@Getter
	private String body;

	/** to */
	@Setter
	@Getter
	private String to;

	/** cc */
	@Setter
	@Getter
	private String cc;

	/** bcc */
	@Setter
	@Getter
	private String bcc;

	/** replyTo */
	@Setter
	@Getter
	private String replyTo;

}
