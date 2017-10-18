package jp.co.isol.manage.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import jp.co.isol.manage.dto.UserInfoDto;
import jp.co.isol.manage.excel.MenuExcelBuilder;
import jp.co.isol.manage.excel.ResultReferenceExcelBuiler;
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
	 * メニュー画面のファイルダウンロード実行する
	 * @param form
	 * @return View
	 */
	@Override
	public View execute(MenuForm form) {
		return new MenuExcelBuilder(form);
	}

	/**
	 * 結果照会画面のファイルダウンロードを実行する
	 * @param historyList
	 * @return
	 */
	@Override
	public View execute(List<UserInfoDto> historyList) {
		return new ResultReferenceExcelBuiler(historyList);
	}

}
