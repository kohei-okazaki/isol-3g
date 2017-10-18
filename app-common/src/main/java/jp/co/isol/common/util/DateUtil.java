package jp.co.isol.common.util;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author kou1210hei<br>
 * 時間関係のutilクラス<br>
 *
 */
public class DateUtil {

	/**
	 * インスタンス生成を制限
	 */
	private DateUtil() {
	}

	/**
	 * 取得したlocaleの時間から書式を整えた時間を返却
	 * @param locale
	 * @return 時刻
	 */
	public static String getFormattedTime(Locale locale) {

		DateFormat format = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		return format.format(new Date()).replaceAll(" JST", StringUtil.TEMP).trim();

	}
}
