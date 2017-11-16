package jp.co.isol.manage.service;

import java.text.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * CSVダウンロードサービスインターフェイス<br>
 *
 */
public interface CsvDownloadService<T> {

	/**
	 * メイン処理
	 * @param request
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	public String execute(T t) throws JsonProcessingException, ParseException;

}
