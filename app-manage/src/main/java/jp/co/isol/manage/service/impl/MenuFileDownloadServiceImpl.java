package jp.co.isol.manage.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import jp.co.isol.manage.excel.MenuExcelBuilder;
import jp.co.isol.manage.form.MenuForm;
import jp.co.isol.manage.service.FileDownloadService;

/**
 * @author kou1210hei<br>
 * メニュー画面ファイルダウンロードサービス実装クラス
 *
 */
@Service(value = "menu")
public class MenuFileDownloadServiceImpl implements FileDownloadService<MenuForm> {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/**
	 * メニュー画面のファイルダウンロード実行する
	 * @param form
	 * @return View
	 */
	@Override
	public View execute(MenuForm form) {
		init();
		return new MenuExcelBuilder(form);
	}

	private void init() {
		LOG.info(this.getClass() + " start");
	}

}
