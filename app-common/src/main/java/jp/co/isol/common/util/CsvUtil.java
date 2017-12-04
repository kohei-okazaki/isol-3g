package jp.co.isol.common.util;

import java.util.Arrays;
import java.util.List;

import jp.co.isol.common.file.csv.annotation.Csv;

/**
 * CsvのUtilクラス<br>
 *
 */
public class CsvUtil {

	/** シングルクォート */
	public static final String SINGLE_QUOTE = "\'";
	/** ダブルクォート */
	public static final String DOBBLE_QUOTE = "\"";

	/**
	 * プライベートコンストラクタ<br>
	 * インスタンスの生成を制限<br>
	 */
	private CsvUtil() {
	}

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
