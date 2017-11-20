package jp.co.isol.common.file.csv;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 * CSV書き込み基底クラス<br>
 *
 */
public abstract class BaseCsvWriter {

	/**
	 * メイン処理を実施
	 * @param response
	 * @throws IOException
	 */
	protected abstract void execute(HttpServletResponse response) throws IOException;

}
