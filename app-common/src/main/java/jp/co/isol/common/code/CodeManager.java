package jp.co.isol.common.code;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import jp.co.isol.common.util.StringUtil;

/**
 * 健康管理_コードマネージャクラス<br>
 *
 */
public class CodeManager {

	/** singletonパターン */
	private static CodeManager instance = new CodeManager();

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
	 * サブキーとメインキーにヒモづくvalueを返す<br>
	 * @param mainKey メインキー
	 * @param subKey サブキー
	 * 	 * @return
	 */
	public String getValue(MainKey mainKey, SubKey subKey) {

		if (subKey == null || mainKey == null) {
			return null;
		}

		Properties properties = new Properties();
		String fileName = "C:\\work\\pleiades\\workspace\\isol-3g\\app-common\\src\\main\\resources\\META-INF\\code.properties";
		String strMainkey = mainKey.toString();
		String strSubkey = subKey.toString();
		String value = "";
		try (InputStream inputStream = new FileInputStream(fileName)) {
			properties.load(inputStream);
			value = properties.getProperty(mainKey.toString() + "_" + subKey.toString());
		} catch (FileNotFoundException e) {
			System.out.println("ファイルがみつからなかった、ファイル名=" + fileName);
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return value;
	}

	/**
	 * サブキーに該当する値のリストを返す<br>
	 * @param subKey サブキー
	 * @return
	 */
	public List<String> getList(SubKey subKey) {

		if (subKey == null) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		return getMocList();
	}

	public final boolean isEquals(String target) {

		if (StringUtil.isEmpty(target)) {
			return false;
		}
		return true;

	}

	public static final String getMocValue() {
		return "10";
	}

	public static final List<String> getMocList() {
		return Arrays.asList("1", "2", "3");
	}

}
