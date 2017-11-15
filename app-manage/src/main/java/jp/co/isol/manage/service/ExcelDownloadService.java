package jp.co.isol.manage.service;

import org.springframework.web.servlet.View;

/**
 * ファイルダウンロードサービスIF
 *
 */
public interface ExcelDownloadService<T> {
	public View execute(T t);
}
