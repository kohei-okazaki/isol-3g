package jp.co.isol.common.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.isol.common.other.Charset;
import jp.co.isol.common.util.FileUtil;
import jp.co.isol.common.util.StringUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 健康管理_メッセージマネージャクラス<br>
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageManager {

	/** singletonパターン */
	private static MessageManager instance = new MessageManager();
	/** メッセージプロパティファイル */
	private static final String MESSAGE_PROPERTIES = "C:\\work\\pleiades\\workspace\\isol-3g\\app-common\\src\\main\\resources\\META-INF\\message.properties";

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

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
			LOG.error("ファイルがみつからなかった、ファイルパスと名前=" + messagePropertyFile);
		} catch (IOException e) {
			LOG.error("ファイルの読み込みに失敗 file=" + messagePropertyFile);
		}

		if (StringUtil.isEmpty(value)) {
			System.out.println("値を取得できませんでした value=" + value);
		}

		return value;
	}
}
