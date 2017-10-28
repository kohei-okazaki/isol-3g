package jp.co.isol.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author kou1210hei<br>
 * 時間関係のutilクラス<br>
 *
 */
public class DateUtil {

	public static final String YYYY_MM_DD_HH_MI_SS = "yyyy/MM/dd hh:mm:ss";

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

	/**
	 * 文字列型の日付を
	 * @param target
	 * @return
	 * @throws ParseException
	 */
	public static Date formatDate(String target) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MI_SS);
		return sdf.parse(target);
	}
}
