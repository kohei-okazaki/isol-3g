package jp.co.isol.manage.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import jp.co.isol.manage.excel.HealthInfoExcelBuilder;
import jp.co.isol.manage.form.HealthInfoForm;
import jp.co.isol.manage.service.FileDownloadService;

/**
 * 健康情報ファイルダウンロードサービス実装クラス
 *
 */
@Service(value = "HealthInfo")
public class HealthInfoFileDownloadServiceImpl implements FileDownloadService<HealthInfoForm> {

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
