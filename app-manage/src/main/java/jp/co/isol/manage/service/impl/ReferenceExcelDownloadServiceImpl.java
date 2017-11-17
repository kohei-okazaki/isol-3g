package jp.co.isol.manage.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.manage.file.excel.ResultReferenceExcelBuiler;
import jp.co.isol.manage.service.ExcelDownloadService;

/**
 * 結果照会画面エクエルダウンロードサービス実装クラス
 *
 */
@Service(value = "referenceExcel")
public class ReferenceExcelDownloadServiceImpl implements ExcelDownloadService<List<HealthInfoDto>> {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/**
	 * 結果照会画面のファイルダウンロードを実行する
	 * @param List<HealthInfoDto>
	 * @return View
	 */
	@Override
	public View execute(List<HealthInfoDto> historyList) {
		init();
		return new ResultReferenceExcelBuiler(historyList);
	}

	private void init() {
		LOG.info(this.getClass() + " start");
	}
}