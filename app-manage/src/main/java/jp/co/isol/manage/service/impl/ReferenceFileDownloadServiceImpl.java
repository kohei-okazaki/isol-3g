package jp.co.isol.manage.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import jp.co.isol.manage.dto.HealthInfoDto;
import jp.co.isol.manage.excel.ResultReferenceExcelBuiler;
import jp.co.isol.manage.service.FileDownloadService;

/**
 * 結果照会画面ファイルダウンロードサービス実装クラス
 *
 */
@Service(value = "reference")
public class ReferenceFileDownloadServiceImpl implements FileDownloadService<List<HealthInfoDto>> {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/**
	 * 結果照会画面のファイルダウンロードを実行する
	 * @param historyList
	 * @return
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
