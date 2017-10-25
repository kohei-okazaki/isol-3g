package jp.co.isol.manage.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import jp.co.isol.manage.dto.UserInfoDto;
import jp.co.isol.manage.excel.ResultReferenceExcelBuiler;
import jp.co.isol.manage.service.FileDownloadService;

/**
 * @author kou1210hei<br>
 * 結果照会画面ファイルダウンロードサービス実装クラス
 *
 */
@Service(value = "reference")
public class ReferenceFileDownloadServiceImpl implements FileDownloadService<List<UserInfoDto>> {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/**
	 * 結果照会画面のファイルダウンロードを実行する
	 * @param historyList
	 * @return
	 */
	@Override
	public View execute(List<UserInfoDto> historyList) {
		init();
		return new ResultReferenceExcelBuiler(historyList);
	}

	private void init() {
		LOG.info(this.getClass() + " start");
	}
}
