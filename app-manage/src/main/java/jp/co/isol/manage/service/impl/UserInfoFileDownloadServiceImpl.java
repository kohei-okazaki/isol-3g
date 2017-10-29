package jp.co.isol.manage.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import jp.co.isol.manage.excel.UserInfoExcelBuilder;
import jp.co.isol.manage.form.UserInfoInputForm;
import jp.co.isol.manage.service.FileDownloadService;

/**
 * @author kou1210hei<br>
 * メニュー画面ファイルダウンロードサービス実装クラス
 *
 */
@Service(value = "UserInfoInput")
public class UserInfoFileDownloadServiceImpl implements FileDownloadService<UserInfoInputForm> {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/**
	 * メニュー画面のファイルダウンロード実行する
	 * @param form
	 * @return View
	 */
	@Override
	public View execute(UserInfoInputForm form) {
		init();
		return new UserInfoExcelBuilder(form);
	}

	private void init() {
		LOG.info(this.getClass() + " start");
	}

}
