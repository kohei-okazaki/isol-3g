package jp.co.isol.manage.service;

import java.io.File;

/**
 * ファイル書き込みサービスIF
 *
 */
public interface FileWriterService {

	/**
	 * 書き込み処理実施
	 * @param file
	 * @param fileMessage
	 */
	public void write(File file);

}
