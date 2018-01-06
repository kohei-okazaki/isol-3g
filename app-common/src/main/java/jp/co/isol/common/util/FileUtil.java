package jp.co.isol.common.util;

import java.io.File;

/**
 * ファイルのUtilクラス<br>
 * インスタンスの生成を制限<br>
 */
public class FileUtil {

	/** 改行 */
	public static final String NEW_LINE = System.getProperty("line.separator");
	/** ファイルの区切り文字 */
	public static final String SEPARATOR = System.getProperty("file.separator");

	private FileUtil() {

	}

	/**
	 * 指定されたパスからファイルを返す<br>
	 * 例)def.txt
	 * @param file
	 * @return
	 */
	public static File getFile(String pathname) {
		return new File(pathname);
	}

	/**
	 * 指定されたパスからファイルのパスの文字列を返す<br>
	 * 例) C:\\abc\\def.txt
	 * @param file
	 * @return
	 */
	public static String getFilePathName(String pathname) {
		return new File(pathname).getPath();
	}

}
