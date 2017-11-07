package jp.co.isol.manage.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;

import jp.co.isol.common.util.FileUtil;
import jp.co.isol.manage.service.FileWriterService;
import jp.co.isol.manage.view.FileMessage;

/**
 * ファイル書き込みサービス実装クラス
 *
 */
@Service
public class FileWriterServiceImpl implements FileWriterService {

	/**
	 * 書き込み処理実施
	 * @param file
	 * @param fileMessage
	 */
	@Override
	public void write(File file, FileMessage fileMessage) {

		try (FileWriter fileWriter = new FileWriter(file)) {
			for (String message : fileMessage.getMessageList()) {
				fileWriter.write(message + FileUtil.NEW_LINE);
			}
			fileWriter.flush();
		} catch (IOException e) {
			System.out.println("---> 書き込み処理失敗");
			e.printStackTrace();
		}

	}

}
