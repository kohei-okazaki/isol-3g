package jp.co.isol.manage.service;

import java.util.List;

import org.springframework.web.servlet.View;

import jp.co.isol.manage.dto.UserInfoDto;
import jp.co.isol.manage.form.MenuForm;

/**
 * @author kou1210hei<br>
 * ファイルダウンロードサービスインターフェイス
 *
 */
public interface FileDownloadService {

	/**
	 * メニュー画面のファイルダウンロード実行する
	 * @param form
	 * @return View
	 */
	public View execute(MenuForm form);

	/**
	 * 結果照会画面のファイルダウンロードを実行する
	 * @param historyList
	 * @return
	 */
	public View execute(List<UserInfoDto> historyList);
}
