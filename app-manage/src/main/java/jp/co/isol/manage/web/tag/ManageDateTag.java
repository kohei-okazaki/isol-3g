package jp.co.isol.manage.web.tag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import jp.co.isol.common.other.DateFormatDefine;
import jp.co.isol.common.util.DateUtil;

/**
 * 管理画面の時刻表示タグ<br>
 *
 */
public class ManageDateTag extends TagSupport {

	/** 時刻 */
	private Date date;

	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int doStartTag() {

		String resultDate = DateUtil.toString(this.date, DateFormatDefine.YYYYMMDD_HHMMSS);
		try {
			pageContext.getOut().print(resultDate);
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
