package jp.co.isol.common.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import jp.co.isol.common.other.Charset;
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

		try (InputStreamReader reader = new InputStreamReader(new FileInputStream(messagePropertyFile), Charset.UTF_8.getName())) {

			Properties properties = new Properties();
			properties.load(reader);
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
