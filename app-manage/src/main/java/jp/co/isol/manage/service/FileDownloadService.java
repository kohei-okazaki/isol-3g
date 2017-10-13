package jp.co.isol.manage.service;

import org.springframework.web.servlet.View;

import jp.co.isol.manage.form.MenuForm;

/**
 * @author kou1210hei<br>
 * ファイルダウンロードサービスインターフェイス
 *
 */
public interface FileDownloadService {

	/**
	 * ファイルダウンロード実行する
	 * @param form
	 * @return View
	 */
	public View execute(MenuForm form);

}
