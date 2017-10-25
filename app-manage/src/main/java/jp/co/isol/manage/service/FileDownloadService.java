package jp.co.isol.manage.service;

import org.springframework.web.servlet.View;

/**
 * @author kou1210hei<br>
 * ファイルダウンロードサービスインターフェイス
 *
 */
public interface FileDownloadService<T> {
	public View execute(T t);
}
