package jp.co.isol.common.util;

import java.util.Arrays;
import java.util.List;

import jp.co.isol.common.file.csv.Csv;

/**
 * CsvのUtilクラス<br>
 *
 */
public class CsvUtil {

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
		Csv excel = getCsvClass(clazz);
		return Arrays.asList(excel.headerNames());
	}

	/**
	 * 指定されたクラス型のCsvアノテーションを返す<br>
	 * @param clazz
	 * @return
	 */
	private static Csv getCsvClass(Class<?> clazz) {
		return clazz.getAnnotation(Csv.class);
	}

}
