package jp.co.isol.common.util;

import java.io.File;

/**
 * ファイルのUtilクラス<br>
 *
 */
public class FileUtil {

	public static final String NEW_LINE = "\r\n";
	public static final String SEPARATOR = "\\";
	public static final String SUFFIX_XLS = ".xls";

	/**
	 * インスタンス生成を制限
	 */
	private FileUtil() {
	}

	/**
	 * 指定されたパスからファイルを返す<br>
	 * @param file
	 * @return
	 */
	public static File getFile(String pathname) {
		return new File(pathname);
	}

	/**
	 * 指定されたパスからファイルのパスの文字列を返す<br>
	 * @param file
	 * @return
	 */
	public static String getFilePathName(String pathname) {
		return new File(pathname).getPath();
	}

}
