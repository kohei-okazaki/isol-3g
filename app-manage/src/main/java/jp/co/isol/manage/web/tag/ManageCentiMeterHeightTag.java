package jp.co.isol.manage.web.tag;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

/**
 * 管理画面身長タグクラス<br>
 *
 */
public class ManageCentiMeterHeightTag extends TagSupport {

	/** 身長(cm) */
	private BigDecimal height;

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int doStartTag() {

		try {
			pageContext.getOut().print(height + " cm");
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
