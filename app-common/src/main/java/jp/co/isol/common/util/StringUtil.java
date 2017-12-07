package jp.co.isol.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 文字列のUtilクラス<br>
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtil {

	public static final String COMMA = ",";
	public static final String HYPHEN = "-";
	public static final String COLON = ":";
	public static final String PERIOD = ".";
	public static final String EMPTY = "";
	public static final String EQUAL = "=";
	public static final String NEW_LINE = "\r\n";

	/** 半角数字 */
	public static final String HALF_NUMBER = "^[0-9]*$";

	/**
	 * 指定された文字列が半角数字かどうか判定する<br>
	 * 半角数字の場合true, それ以外の場合falseを返す
	 * @param target
	 * @return
	 */
	public static boolean isHalfNumber(String target) {
		return Pattern.compile(HALF_NUMBER).matcher(target).find();
	}

	/**
	 * 区切りたい文字列を区切り文字で、区切ったリストを返す
	 * @param target
	 * @param delim
	 * @return result
	 */
	public static List<String> toStrList(String target, String delim) {

		if (Objects.isNull(target) || EMPTY.equals(target)) {
			return null;
		}
		List<String> result = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(target, COMMA);

		while (tokenizer.hasMoreTokens()) {
			result.add(tokenizer.nextToken().trim());
		}
		return result;

	}

	/**
	 * 空文字かどうか判定する
	 * @param target
	 * @return 判定結果
	 */
	public static boolean isEmpty(String target) {
		return Objects.isNull(target) || EMPTY.equals(target.trim());
	}


}
