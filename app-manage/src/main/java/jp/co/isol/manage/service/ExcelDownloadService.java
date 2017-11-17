package jp.co.isol.manage.service;

import org.springframework.web.servlet.View;

/**
 * ファイルダウンロードサービスIF
 *
 */
public interface ExcelDownloadService<T> {

	/**
	 * メイン処理
	 * @param t
	 * @return
	 */
	public View execute(T t);

}
