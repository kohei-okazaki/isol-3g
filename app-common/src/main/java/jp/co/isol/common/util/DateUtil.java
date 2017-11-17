package jp.co.isol.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author kou1210hei<br>
 * 時間関係のutilクラス<br>
 *
 */
public class DateUtil {

	public static final String YYYY_MM_DD_HH_MI_SS = "yyyy/MM/dd hh:mm:ss";
	public static final String YYYYMMDD_HHMMSS = "yyyy/MM/dd HH:mm:ss";

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
		return format.format(new Date()).replaceAll(" JST", StringUtil.EMPTY).trim();

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

	/**
	 * 指定した日付の加算を行う<br>
	 * @param targetDate 元の日付
	 * @param add 加算する日数
	 * @return
	 */
	public static Date addDate(Date targetDate, int addDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(targetDate);
		calendar.add(Calendar.DATE, addDay);
		return calendar.getTime();
	}

	/**
	 * 指定した月の加算を行う<br>
	 * @param targetDate 元の日付
	 * @param addMonth 加算する月数
	 * @return
	 */
	public static Date addMonth(Date targetDate, int addMonth) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(targetDate);
		calendar.add(Calendar.MONTH, addMonth);
		return calendar.getTime();
	}

	/**
	 * Date型を指定されたフォーマットに変える<br>
	 * @return
	 */
	public static String toString(Date targetDate, String format) {
		if (StringUtil.isEmpty(format)) {
			return StringUtil.EMPTY;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(targetDate);
	}
}
