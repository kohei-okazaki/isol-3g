package jp.co.isol.manage.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import jp.co.isol.manage.file.excel.HealthInfoExcelBuilder;
import jp.co.isol.manage.form.HealthInfoForm;
import jp.co.isol.manage.service.ExcelDownloadService;

/**
 * 健康情報エクエルダウンロードサービス実装クラス
 *
 */
@Service(value = "healthInfoExcel")
public class HealthInfoExcelDownloadServiceImpl implements ExcelDownloadService<HealthInfoForm> {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/**
	 * メニュー画面のファイルダウンロード実行する
	 * @param form
	 * @return View
	 */
	@Override
	public View execute(HealthInfoForm form) {
		init();
		return new HealthInfoExcelBuilder(form);
	}

	private void init() {
		LOG.info(this.getClass() + " start");
	}

}
