package jp.co.isol.common.util;

import java.io.File;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * ファイルのUtilクラス<br>
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileUtil {

	public static final String NEW_LINE = "\r\n";
	public static final String SEPARATOR = "\\";

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
