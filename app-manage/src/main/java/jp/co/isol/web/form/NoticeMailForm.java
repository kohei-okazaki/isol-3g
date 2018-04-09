package jp.co.isol.web.form;

import java.io.Serializable;

import jp.co.isol.common.web.manage.BaseForm;

/**
 * 送信するメールオブジェクトクラス
 *
 */
public class NoticeMailForm implements BaseForm, Serializable {

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

	/**
	 * デフォルトコンストラクタ<br>
	 */
	public NoticeMailForm() {

	}

	/**
	 * fromを返す
	 * @return from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * fromを設定する
	 * @param from
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * subjectを返す
	 * @return subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * subjectを設定する
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * bodyを返す
	 * @return body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * bodyを設定する
	 * @param body
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * toを返す
	 * @return to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * toを設定する
	 * @param to
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * ccを返す
	 * @return cc
	 */
	public String getCc() {
		return cc;
	}

	/**
	 * ccを設定する
	 * @param cc
	 */
	public void setCc(String cc) {
		this.cc = cc;
	}

	/**
	 * bccを返す
	 * @return bcc
	 */
	public String getBcc() {
		return bcc;
	}

	/**
	 * bccを設定する
	 * @param bcc
	 */
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	/**
	 * replyToを返す
	 * @return replyTo
	 */
	public String getReplyTo() {
		return replyTo;
	}

	/**
	 * replyToを設定する
	 * @param replyTo
	 */
	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

}
