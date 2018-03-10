package jp.co.isol.manage.web.tag;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

/**
 * 管理画面の体重タグクラス<br>
 *
 */
public class ManageWeightTag extends TagSupport {

	/** 体重(kg) */
	private BigDecimal weight;

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int doStartTag() {

		try {
			pageContext.getOut().print(weight + " kg");
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
