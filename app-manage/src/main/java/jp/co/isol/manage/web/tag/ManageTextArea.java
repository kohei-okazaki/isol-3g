package jp.co.isol.manage.web.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

/**
 * 管理画面のテキストエリアタグクラス<br>
 *
 */
public class ManageTextArea extends TagSupport {

	/** 値 */
	private String value;
	/** 1行あたりの文字数 */
	private String count;

	/**
	 * valueを設定する
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * countを設定する
	 * @param count
	 */
	public void setCount(String count) {
		this.count = count;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int doStartTag() {

		List<String> textList = new ArrayList<String>();
		Matcher m = Pattern.compile("[\\s\\S]{1," + count + "}").matcher(value);
		while (m.find()) {
		    textList.add(m.group());
		}

		try {
			for (String text : textList) {
				pageContext.getOut().println(text);
			}
		} catch (IOException e) {
			Logger.getLogger(this.getClass().getName());
		}

		return EVAL_PAGE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int doEndTag() {
		return EVAL_PAGE;
	}
}
