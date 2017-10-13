package jp.co.isol.manage.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import jp.co.isol.manage.excel.ExcelBuilder;
import jp.co.isol.manage.form.MenuForm;
import jp.co.isol.manage.service.FileDownloadService;

/**
 * @author kou1210hei<br>
 * ファイルダウンロードサービス実装クラス
 *
 */
@Service
public class FileDownloadServiceImpl implements FileDownloadService {

	/**
	 * ファイルダウンロード実行する
	 * @param form
	 * @return View
	 */
	@Override
	public View execute(MenuForm form) {
		return new ExcelBuilder(form);

	}

}
