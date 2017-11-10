package jp.co.isol.common.message;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import jp.co.isol.common.util.FileUtil;
import jp.co.isol.common.util.StringUtil;

/**
 * 健康管理_メッセージマネージャクラス<br>
 *
 */
public class MessageManager {

	/** singletonパターン */
	private static MessageManager instance = new MessageManager();
	/** コードプロパティ */
	private static final String MESSAGE_PROPERTIES = "C:\\work\\pleiades\\workspace\\isol-3g\\app-common\\src\\main\\resources\\META-INF\\message.properties";

	/**
	 * プライベートコンストラクタ<br>
	 * インスタンスの生成を制限<br>
	 */
	private MessageManager() {
	}

	/**
	 * MessageManagerインスタンスを取得する<br>
	 * @return
	 */
	public static MessageManager getInstance() {
		return instance;
	}

	/**
	 * 値を取得する<br>
	 * @param target
	 * @return
	 */
	public String getValue(String target) {

		if (StringUtil.isEmpty(target)) {
			return StringUtil.EMPTY;
		}

		String messagePropertyFile = FileUtil.getFilePathName(MESSAGE_PROPERTIES);
		String value = "";

		try (InputStream inputStream = new FileInputStream(messagePropertyFile)) {

			Properties properties = new Properties();
			properties.load(inputStream);
			value = properties.getProperty(target);

		} catch (FileNotFoundException e) {
			System.out.println("ファイルがみつからなかった、ファイルパスと名前=" + messagePropertyFile);
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (StringUtil.isEmpty(value)) {
			System.out.println("値を取得できませんでした value=" + value);
		}

		return value;
	}
}
