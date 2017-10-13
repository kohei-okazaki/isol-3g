package jp.co.isol.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author kou1210hei<br>
 * 文字列のUtilクラス<br>
 *
 */
public class StringUtil {

	public static final String COMMA = ",";
	public static final String HYPHEN = "-";
	public static final String COLON = ":";
	public static final String PERIOD = ".";
	public static final String TEMP = "";
	public static final String EQUAL = "=";
	public static final String NEW_LINE = "\r\n";

	/**
	 * インスタンス生成を制限
	 */
	private StringUtil() {
	}

	/**
	 * 区切りたい文字列を区切り文字で、区切ったリストを返す
	 * @param target
	 * @param delim
	 * @return result
	 */
	public static List<String> toStrList(String target, String delim) {

		if (target == null || "".equals(target)) {
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
		return target == null || TEMP.equals(target.trim());
	}


}
