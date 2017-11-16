package jp.co.isol.common.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.isol.common.other.Charset;
import jp.co.isol.common.util.FileUtil;
import jp.co.isol.common.util.StringUtil;

/**
 * 健康管理_コードマネージャクラス<br>
 *
 */
public class CodeManager {

	/** singletonパターン */
	private static CodeManager instance = new CodeManager();
	/** コードプロパティファイル */
	private static final String CODE_PROPERTIES = "C:\\work\\pleiades\\workspace\\isol-3g\\app-common\\src\\main\\resources\\META-INF\\code.properties";

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/**
	 * プライベートコンストラクタ<br>
	 * インスタンスの生成を制限する<br>
	 */
	private CodeManager() {
	}

	/**
	 * CodeManagerインスタンスを取得する<br>
	 * @return
	 */
	public static final CodeManager getInstance() {
		return instance;
	}

	/**
	 * メインキーとサブキーにヒモづくvalueを返す<br>
	 * @param mainKey メインキー
	 * @param subKey サブキー
	 * @return ひもづく値
	 */
	public String getValue(MainKey mainKey, SubKey subKey) {

		if (Objects.isNull(mainKey) || Objects.isNull(subKey)) {
			return null;
		}

		String codePorpertyFile = FileUtil.getFilePathName(CODE_PROPERTIES);
		String value = "";

		try (InputStreamReader reader = new InputStreamReader(new FileInputStream(codePorpertyFile), Charset.UTF_8.getName())) {

			Properties properties = new Properties();
			properties.load(reader);
			value = properties.getProperty(mainKey.toString() + "_" + subKey.toString());

		} catch (FileNotFoundException e) {
			LOG.error("ファイルがみつからなかった、ファイルパスと名前=" + codePorpertyFile);
		} catch (IOException e) {
			LOG.error("ファイルの読み込みに失敗 file=" + codePorpertyFile);
		}

		if (StringUtil.isEmpty(value)) {
			System.out.println("値を取得できませんでした value=" + value);
		}

		return value;
	}

	/**
	 * サブキーに該当する値のリストを返す<br>
	 * @param subKey サブキー
	 * @return
	 */
	public List<String> getList(MainKey mainKey) {

		if (Objects.isNull(mainKey)) {
			return null;
		}

		List<String> porpList = new ArrayList<String>();
		String codePorpertyFile = FileUtil.getFilePathName(CODE_PROPERTIES);

		try (InputStreamReader reader = new InputStreamReader(new FileInputStream(codePorpertyFile), Charset.UTF_8.getName())) {

			Properties properties = new Properties();
			properties.load(reader);

			for (Object key : properties.keySet()) {

				if (Objects.isNull(key)) {
					continue;
				}
				String strKey = (String) key;

				if (strKey.startsWith(mainKey.toString())) {
					porpList.add(properties.getProperty(strKey));
				}
			}

		} catch (FileNotFoundException e) {
			LOG.error("ファイルがみつからなかった、ファイルパスと名前=" + codePorpertyFile);
		} catch (IOException e) {
			LOG.error("ファイルの読み込みに失敗 file=" + codePorpertyFile);
		}

		return porpList;
	}

	/**
	 * 指定された値がメインキー、サブキーから取得される値と一致するか判定する<br>
	 * 一致した場合true, そうでなければfalseを返す<br>
	 * @param mainKey
	 * @param subKey
	 * @param target
	 * @return 判定結果
	 */
	public final boolean isEquals(MainKey mainKey, SubKey subKey, String target) {

		if (StringUtil.isEmpty(target)) {
			return false;
		}

		return target.equals(getValue(mainKey, subKey));

	}

}
