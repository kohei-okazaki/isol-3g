package jp.co.isol.manage.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;

import jp.co.isol.common.message.MessageManager;
import jp.co.isol.common.util.FileUtil;
import jp.co.isol.manage.service.FileWriterService;

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
	public void write(File file) {

		MessageManager manager = MessageManager.getInstance();
		try (FileWriter fileWriter = new FileWriter(file)) {

			fileWriter.write(manager.getValue("height") + FileUtil.NEW_LINE);
			fileWriter.write(manager.getValue("weight") + FileUtil.NEW_LINE);
			fileWriter.write(manager.getValue("bmi") + FileUtil.NEW_LINE);
			fileWriter.write(manager.getValue("standardWeight") + FileUtil.NEW_LINE);

			fileWriter.flush();

		} catch (IOException e) {
			System.out.println("---> 書き込み処理失敗");
			e.printStackTrace();
		}

	}

}
