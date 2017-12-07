package jp.co.isol.common.util;

import java.util.Arrays;
import java.util.List;

import jp.co.isol.common.file.csv.annotation.Csv;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * CsvのUtilクラス<br>
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CsvUtil {

	/** シングルクォート */
	public static final String SINGLE_QUOTE = "\'";
	/** ダブルクォート */
	public static final String DOBBLE_QUOTE = "\"";

	/**
	 * ヘッダ名を取得する
	 * @param clazz
	 * @return ヘッダー名
	 */
	public static List<String> getHeaderList(Class<?> clazz) {
		return Arrays.asList(getCsvClass(clazz).headerNames());
	}

	/**
	 * 指定されたクラス型付けてるCsvアノテーションを返す<br>
	 * @param clazz
	 * @return
	 */
	public static Csv getCsvClass(Class<?> clazz) {
		return clazz.getAnnotation(Csv.class);
	}

}
