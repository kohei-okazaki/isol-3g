package jp.co.isol.common.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import jp.co.isol.common.util.FileUtil;
import jp.co.isol.common.util.StringUtil;

/**
 * 健康管理_コードマネージャクラス<br>
 *
 */
public class CodeManager {

	/** singletonパターン */
	private static CodeManager instance = new CodeManager();
	/** コードプロパティ */
	private static final String CODE_PROPERTIES = "C:\\work\\pleiades\\workspace\\isol-3g\\app-common\\src\\main\\resources\\META-INF\\code.properties";

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

		try (InputStreamReader reader = new InputStreamReader(new FileInputStream(codePorpertyFile), "UTF-8")) {

			Properties properties = new Properties();
			properties.load(reader);
			value = properties.getProperty(mainKey.toString() + "_" + subKey.toString());

		} catch (FileNotFoundException e) {
			System.out.println("ファイルがみつからなかった、ファイルパスと名前=" + codePorpertyFile);
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
	public List<String> getList(SubKey subKey) {

		if (Objects.isNull(subKey)) {
			return null;
		}

		List<String> list = new ArrayList<String>();
		File propFile = FileUtil.getFile(CODE_PROPERTIES);
		try (BufferedReader br = new BufferedReader(new FileReader(propFile))) {
			while (true) {

				String value = br.readLine();
				if (Objects.nonNull(value) && subKey.toString().contains(value)) {
					list.add(value);
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println("ファイルがみつからなかった、ファイルパスと名前=" + CODE_PROPERTIES);
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
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
