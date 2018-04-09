package jp.co.isol.web.service;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CSVダウンロードサービスインターフェース<br>
 *
 */
public interface CsvDownloadService {

	/**
	 * メイン処理
	 * @param request
	 * @param response
	 * @throws ParseException
	 * @throws IOException
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
