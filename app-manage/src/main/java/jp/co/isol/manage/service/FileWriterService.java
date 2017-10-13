package jp.co.isol.manage.service;

import java.io.File;

import jp.co.isol.manage.view.FileMessage;

/**
 * @author kou1210hei<br>
 * ファイル書き込みサービス
 *
 */
public interface FileWriterService {

	/**
	 * 書き込み処理実施
	 * @param file
	 * @param fileMessage
	 */
	public void write(File file, FileMessage fileMessage);

}
