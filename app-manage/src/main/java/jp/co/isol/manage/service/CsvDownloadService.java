package jp.co.isol.manage.service;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CSVダウンロードサービスインターフェイス<br>
 *
 */
public interface CsvDownloadService {

	/**
	 * メイン処理
	 * @param request
	 * @throws ParseException
	 * @throws IOException
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException;

}
