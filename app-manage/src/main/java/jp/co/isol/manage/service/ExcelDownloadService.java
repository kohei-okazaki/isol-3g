package jp.co.isol.manage.service;

import org.springframework.web.servlet.View;

/**
 * Excelダウンロードサービスインターフェース<br>
 * 継承先で@Service(value = "サービス実装用のAnnotation") をつけてInjectionすること<br>
 * @param <T> 出力対象データ
>>>>>>> origin/master
 */
public interface ExcelDownloadService<T> {

	/**
	 * メイン処理<br>
	 * 継承先で詳細を書く<br>
	 * 渡したいデータを引数に指定する<br>
	 * @param t
	 * @return
	 */
	public View execute(T t);

}
